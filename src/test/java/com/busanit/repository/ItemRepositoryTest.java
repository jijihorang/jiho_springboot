package com.busanit.repository;

import com.busanit.constant.ItemSellStatus;
import com.busanit.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    public void createItemList() {
        for(int i = 1; i <= 10; i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

            Item savedItem = itemRepository.save(item);

            System.out.println(savedItem.toString());
        }
    }

    @Test
    @DisplayName("상품 조회 테스트")
    public void findByItemNmTest() {

        // 10개 item 생성
        createItemList();

        // List<Item> itemList = itemRepository.findByItemNm("테스트 상품 1");  /* 조회 */
        List<Item> itemList = itemRepository.findAll();
        for(Item item : itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());

        Item savedItem = itemRepository.save(item); /* save는 JpaRepository가 가지는 메서드다 */

        System.out.println(savedItem.toString());
    }
}