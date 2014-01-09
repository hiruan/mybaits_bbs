package dao.board;

import java.util.List;

import model.board.BoardModel;
import mybatis.MyBatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * 게시판 DAO 클래스 (데이터베이스 질의문 실행)
 * @since 2014.01.08
 * @author hiruan
 */
public class BoardDAO implements BoardDAOImpl {
	/** Mybatis SQL 팩토리 */
	private SqlSessionFactory sessionFactory = null;
	
	public BoardDAO() {
		this.sessionFactory = MyBatis.getSqlSessionFactory();
	}

	/**
	 * 게시판 목록 조회
	 * @param boardModel
	 * @return
	 */
	public List<BoardModel> selectList(BoardModel boardModel) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectList("board.selectList", boardModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return null;
	}
	
	/**
	 * 게시판 수 조회
	 * @param boardModel
	 * @return
	 */
	public int selectCount(BoardModel boardModel) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectOne("board.selectCount", boardModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return 0;
	}
	
	/**
	 * 게시판 상세 조회
	 * @param boardModel
	 * @return
	 */
	public BoardModel select(BoardModel boardModel) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectOne("board.select", boardModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return null;
	}
	
	/**
	 * 게시판 등록 처리
	 * @param boardModel
	 */
	public void insert(BoardModel boardModel) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.insert("board.insert", boardModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}
	
	/**
	 * 게시판 수정 처리
	 * @param boardModel
	 */
	public void update(BoardModel boardModel) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.update("board.update", boardModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}
	
	/**
	 * 게시판 조회수 증가 수정 처리
	 * @param boardModel
	 */
	public void updateHit(BoardModel boardModel) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.insert("board.updateHit", boardModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}
	
	/**
	 * 게시판 삭제 처리
	 * @param boardModel
	 */
	public void delete(BoardModel boardModel) {
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.delete("board.delete", boardModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}
	
}

