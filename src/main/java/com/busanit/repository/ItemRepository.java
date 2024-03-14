package com.busanit.repository;

import com.busanit.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {  /* item_id의 타입인 Long 적어야 함 */
    /*
       JpaRepository 지원하는 메소드 예시
       (1) <S extends T> save(S entity) - 엔티티 저장 및 수정
       (2) void delete(T entity) - 엔티티 삭제
       (3) count() - 엔티티 총 갯수 반환
       (4) Iterable<T> findAll() - 모든 엔티티 조회
    */

    /*
        find + (엔티티 이름) + By + 변수이름
        - 엔티티 이름은 생략 가능, By 뒤에는 검색할 때 사용할 변수의 이름을 적어줌
    */

    List<Item> findByItemNm(String itemNm);

}
