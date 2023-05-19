package com.example.sbb;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.sbb.answer.Answer;
import com.example.sbb.answer.AnswerRepository;
import com.example.sbb.question.Question;
import com.example.sbb.question.QuestionRepository;
import com.example.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa() {

		for (int i = 1; i <= 300; i++) {
			String subject = String.format("게시글 제목:[%03d]", i);
			String content = String.format("게시글 내용:[%03d]", i);
			this.questionService.create(subject, content, null);
		}

		/*
		int a = 0;
		//데이터 저장
		while(a<=200) {
			Question q1 = new Question();
			q1.setSubject("Subject" + a++);
			q1.setContent("Content");
			q1.setCreateDate(LocalDateTime.now());
			this.questionRepository.save(q1);  // 첫번째 질문 저장
			}
		 */


		/*
		Question q2 = new Question();
		q2.setSubject("질문게시판 빈공간 채우는 제목");
		q2.setContent("질문게시판 빈공간 채우는 내용");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장
		 */

		/*
		//데이터 조회
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size()); //

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		 */

		/*
		//findById사용 조회
		Optional<Question> oq = this.questionRepository.findById(1); // 질문 당 답변은 있을수도, 없을수도 있는 선택적 관계이기 때문에 옵셔널리티를 사용
		// oq 옵셔널 객체에 1번 아이디를 가진 퀘스천 데이터 삽입
		if(oq.isPresent()) { // 위 번호를 불러올 수 있는지 없는지 판단.(만약, 질문이 존재한다면?)
			Question q = oq.get(); // lombok을 사용한 getter로 가져와서 Question타입 q에 할당.
			assertEquals("sbb가 무엇인가요?", q.getSubject()); // 수정된 q를 퀘스천 리포지터리에 저장.
			// assertEquals는 엄격한 비교식
		}
		*/

		/*
		//findBySubject
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?"); // 엔티티의 SUBJECT 칼럼에 있는 내용을 비교
		assertEquals(21, q.getId()); // Question 테이블의 21번 id값을 가져와서 비교
//		findBy + 엔티티의 속성명을 사용하면 같은 리포지터리 메서드를 작성하면 해당 속성의 값으로 데이터를 조회할수 있다.
		 */

		/*
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다."); // 엔티티의 SUBJECT 칼럼에 있는 내용을 비교
		assertEquals(21, q.getId()); // Question 테이블의 21번 id값을 가져와서 비교
		//subject, content 컬럼이 and 조건으로 where문에 사용됨.(쿼리문)
		 */

		/*
		//findBySubjectLike
		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%"); // QuestionRepository에 있는 findBySubjectLike 메서드를 활용해서 sbb로 시작하는 문자열을 검색
		Question q = qList.get(0); // ArrayList상 0번인덱스에 있는 값을 가져와서 Question 타입의 q 변수에 넣음.
		assertEquals("sbb가 무엇인가요?", q.getSubject()); // Question 테이블의 sbb가 무엇인가요? 라는 subject값을 가져와서 비교
		 */

		/*
		//데이터 수정
		Optional<Question> oq = this.questionRepository.findById(21); // 옵셔널 객체에 1번 아이디를 가진 퀘스천 데이터 삽입
		assertTrue(oq.isPresent()); // 값이 있는지 없는지(참 거짓) 판단
		// assertTrue는 괄호안의 값이 무조건 참이다 라고 못박는 함수, 그래서 해당 assertTrue에서 거짓으로 에러가 나면 멈춤.
		Question q = oq.get(); // Question타입 q변수에 oq.get();
		q.setSubject("야발라히비기야"); // q에 담긴 제목을 setter를 이용해서 괄호안에 수정된 문자열로 수정한다
		this.questionRepository.save(q); // .save()를 통해서 setter로만 남아있는 수정된 제목을 실제로 DB에 전송하여 저장한다.
		 */

		/*
		//데이터 삭제
		assertEquals(7, this.questionRepository.count()); // 현재 Question엔티티에 있는 튜플갯수를 세어봄
		Optional<Question> oq = this.questionRepository.findById(1); // findById()괄호안에 숫자에 맞는 id값의 튜플을 전체 소환해서 oq에 대입
		assertTrue(oq.isPresent()); // 그 oq에 대입된 값이 실제로 존재한다 라고 선언하는 격으로 놓고 만약 없다면 에러가 터지게 장치
		Question q = oq.get(); // oq.get으로 getter 사용해서 oq에 담겨있는 값을 가져와서 q에 대입
		this.questionRepository.delete(q); // .delete()괄호안에 있는 값이 삭제되도록 함, 여기선 q에 대입된 값이 삭제되는 과정
		assertEquals(6, this.questionRepository.count()); // 2개 있던 튜플 중 1개가 지워져서 1개가 되었으니 그 상태를 참, 거짓으로 판별
		 */

		/*
		//답변 데이터 생성 후 저장
		Optional<Question> oq = this.questionRepository.findById(26); // findById를 통해서 어떤 튜플에 답변을 달지 지정.
		assertTrue(oq.isPresent()); // 해당 튜플이 존재하는지 확인(참이라고 못박아놓고 거짓이면 에러터짐.)
		Question q = oq.get(); // oq.get으로 getter 사용해서 oq에 담겨있는 값을 가져와서 q에 대입(하단코드의 Answer에서 외래키로 사용될 예정)

		Answer a = new Answer(); // Answer엔티티 객체를 a로 인스턴스화
		a.setContent("26번 질문의 답변데이터 입니다."); // Answer엔티티의 Content에 들어갈 내용을 setter로 셋팅해줌.
		a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.(위에서 oq.get으로 가져온 Question엔티티 튜플 = 외래키 셋팅)
		a.setCreateDate(LocalDateTime.now()); // 답변 생성일로 작용할 LocalDateTime.now()를 사용해서 생성일 셋팅
		this.answerRepository.save(a); // 위에서 setter로 셋팅된 값들을 직접 answerRepository에 보내서 저장.
		 */

		/*
		//답변 조회
		Optional<Answer> oa = this.answerRepository.findById(2); // Answer
		assertTrue(oa.isPresent()); // True
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId());
		 */

		/*
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(2, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
		 */
	}
}
