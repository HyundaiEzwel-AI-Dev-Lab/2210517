---
name: spring-mapper-setup
description: Spring Boot 프로젝트에 MyBatis 매퍼와 연동 테스트를 구성하고, 컨트롤러·서비스·DAO·DTO 구조를 자동으로 생성하는 방법
source: auto-skill
extracted_at: '2026-06-22T12:45:00.964Z'
---

## 개요
이 자동 스킬은 Spring Boot 애플리케이션에 다음과 같은 레이어를 구축하고, MyBatis 매퍼를 사용해 데이터베이스 쿼리를 실행하도록 연결하는 전체 흐름을 설명합니다.

1. **패키지 및 샘플 클래스 생성** – `controller`, `service`, `dao`, `dto` 패키지를 만든 뒤 각각 `SampleController`, `SampleService`, `SampleDao`, `SampleDto` 클래스를 구현.
2. **MyBatis 의존성 추가** – `pom.xml`에 `mybatis-spring-boot-starter` 를 삽입.
3. **매퍼 인터페이스와 XML 매핑** – `mapper` 패키지에 `SampleMapper` 인터페이스를 만들고, `@Select` 어노테이션으로 간단한 쿼리를 정의.
4. **DAO 수정** – `SampleDao`에 `SampleMapper` 를 주입하고, `fetchSample()` 메서드를 매퍼 호출로 교체. 필요 import와 생성자를 추가.
5. **테스트 코드** – 
   * `controller` 테스트 (`SampleControllerTest`) – `MockMvc`와 `@MockBean` 으로 서비스 동작을 검증.
   * `mapper` 테스트 (`SampleMapperTest`) – `@MybatisTest` 로 매퍼가 H2 (또는 기본 데이터소스)와 정상 동작하는지 확인.
6. **전체 통합 검증** – `mvn test` 로 모든 테스트가 통과하면 컨트롤러 → 서비스 → DAO → 매퍼 흐름이 정상임을 확인.

## 단계별 절차
### 1. 패키지·클래스 생성
```bash
mkdir -p src/main/java/com/example/demo/{controller,service,dao,mapper,dto}
# 각각 샘플 파일 작성 (Controller, Service, Dao, Dto)
```
### 2. MyBatis 의존성 삽입
`pom.xml`에서 `</dependencies>` 바로 앞에 다음을 추가:
```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>
```
### 3. 매퍼 인터페이스
`src/main/java/com/example/demo/mapper/SampleMapper.java`
```java
package com.example.demo.mapper;

import com.example.demo.dto.SampleDto;
import org.apache.ibatis.annotations.Select;

public interface SampleMapper {
    @Select("SELECT 'Hello' AS message, 42 AS value")
    SampleDto fetchSample();
}
```
### 4. DAO 업데이트
* `import com.example.demo.mapper.SampleMapper;`
* `private final SampleMapper sampleMapper;`
* 생성자 주입 및 `fetchSample()` 구현을 매퍼 호출로 교체.
### 5. 테스트 구현
#### Controller 테스트 (`src/test/java/com/example/demo/controller/SampleControllerTest.java`)
* `@WebMvcTest`, `@MockBean SampleService`, `MockMvc` 로 `/api/sample` 엔드포인트 검증.
#### Mapper 테스트 (`src/test/java/com/example/demo/mapper/SampleMapperTest.java`)
* `@MybatisTest`와 `@Autowired SampleMapper` 로 간단한 SELECT 반환값을 확인.
### 6. 전체 실행 검증
```bash
mvn -B test   # 모든 단위·통합 테스트 실행
```
테스트가 성공하면 컨트롤러 → 서비스 → DAO → 매퍼 흐름이 정상 연결된 것입니다.

## 활용 팁
* 실제 DB 연결이 필요하면 `application.yml`에 H2 혹은 PostgreSQL 설정을 추가하고, 매퍼 쿼리를 실제 테이블에 맞게 교체하십시오.
* 매퍼 메서드가 복잡해질 경우 XML 매핑 파일(`src/main/resources/mappers/SampleMapper.xml`)을 사용해 유지보수성을 높일 수 있습니다.

---
이 스킬은 프로젝트에 MyBatis 매퍼 기반 데이터 흐름을 빠르게 셋업하고 검증하는 재사용 가능한 절차를 제공합니다.
