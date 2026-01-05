## 학습 목표
- HTTP 요청이 들어와서 응답이 나가기까지의 **전체 흐름을 코드로 추적**
- 프론트 컨트롤러를 직접 구현하며 **MVC 패턴의 역할 분리** 이해
- 스프링 MVC가 내부적으로 제공하는 **HandlerMapping / HandlerAdapter / DispatcherServlet** 구조 이해


## 학습 흐름(목차)
### 1. Servlet 기본
- Request/Response 객체 생성과 역할
- 응답 헤더/바디(Content-Type, Charset)
- InputStream 바이트 → 문자열 변환(UTF-8)

### 2. Front Controller 패턴 (V1 ~ V4)
- URL → 컨트롤러 매핑 구조(controllerMap)
- View 분리(MyView, forward)
- ModelView 도입과 뷰 리졸빙
- HandlerAdapter로 다양한 컨트롤러 방식 공존(확장성)

### 3. Spring MVC로 확장
- DispatcherServlet 호출 흐름
- @Controller + @RequestMapping 기반 매핑 등록
- HandlerMapping / HandlerAdapter가 자동으로 선택되는 이유
- “옛날 Controller 인터페이스 방식”과의 비교
