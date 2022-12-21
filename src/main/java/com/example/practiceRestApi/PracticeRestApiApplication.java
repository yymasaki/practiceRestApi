package com.example.practiceRestApi;

import com.example.practiceRestApi.repository.ItemRepository;
import com.example.practiceRestApi.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeRestApiApplication implements CommandLineRunner {


	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(PracticeRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		itemRepository.save(new Item("ネックレス", "ジュエリ"));
		itemRepository.save(new Item("パーカー", "ファッション"));
		itemRepository.save(new Item("フェイスクリーム", "ビューティー"));
		itemRepository.save(new Item("サプリメント", "ヘルス"));
		itemRepository.save(new Item("ブルーベリー", "フード"));
	}
}
