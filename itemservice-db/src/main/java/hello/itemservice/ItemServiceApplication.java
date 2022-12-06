package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Slf4j
//@Import(MemoryConfig.class)
//@Import(JdbcTemplateV1Config.class)
//@Import(JdbcTemplateV2Config.class)
//@Import(JdbcTemplateV3Config.class)
//@Import(MyBatisConfig.class)
@Import(JpaConfig.class)
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

	/**
	 * test 를 위한 메모리 DB 설정
	 * test 폴더 밑에 sql 파일 생성

	@Bean
	@Profile("test")
	public DataSource dataSource() {
		log.info("메모리 데이터베이스 추가");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1"); // 임베디드 모드로 동작하는 H2DB 사용가능, 뒤에는 데이터 베이스 종료 방지 설정
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	 * 따로 이렇게 설정해주지 않으면
	 * 스프링이 알아서 임베디드 모드로 접근하는 DataSource 를 만들어서 제공한다.. ㄷㄷㄷ
	 * propertise에서도 DB관련 코드를 주석처리 했는데 잘 되는 걸 확인 할 수 있다.
	 * 결론적으로 TEST 코드에 @Transactional 만 작성해주면 끝!!! 대박이다 진짜
	 */
}
