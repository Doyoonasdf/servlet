package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);

        response.getWriter().write("ok");

    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- RQUEST-LINE - start ---");

        System.out.println("request.getMethod() =" + request.getMethod()); //GET
        System.out.println("request.getProtocol() =" + request.getProtocol()); // HTTP/1.1
        System.out.println("request.getScheme() =" + request.getScheme());// http
        System.out.println("request.getRequestURL() =" + request.getRequestURL()); // http://localhost:8080/request-header
        System.out.println("request.getRequestURI() =" + request.getRequestURI()); // request-header
        System.out.println("request.getQueryString() =" + request.getQueryString()); // username=hi
        System.out.println("request.isSecure() =" + request.isSecure()); // https 사용유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }


    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- HEADERS - start ---");

        /*

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName+ ":" + request.getHeader(headerName));
        }

         */
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));

        /*
        * host: localhost:8080
        * connection : keep-alive
        * cache-control: max-age=0
        * sec-ch-ua:"Chromium";v="88", "Google Chrome";v="88", ";Not A Brand";v="99"
        * sec-ch-ua-mobile:?0
        * upgrade-inscure-requests:1
        * user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36
        *  ...
        * */
        System.out.println("--- HEADERS - end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() =" + request.getServerName()); // localhost
        System.out.println("request.getServerPort() =" + request.getServerPort()); // 8080
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");

        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        //locale = ko
        //locale = en_US
        //locale = en
        //locale = ko_KR
        //request.getLocale() = ko

        System.out.println("request.getLocale() = " + request.getLocale());

        System.out.println();

        System.out.println("[coockie 편의 조회]");

        if(request.getCookies()!= null){
            for(Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + ": "+ cookie.getValue());
            }
        }

        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType()); // null
        System.out.println("request.getContentLength() = " + request.getContentLength()); // -1
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding()); // UTF-8

        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }



    private void printEtc(HttpServletRequest request) {
       System.out.println("--- 기타 조회 start ---");

        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //  0:0:0:0:0:0:0:1
        System.out.println("request.getRemoteAddr() =" + request.getRemoteAddr()); //  0:0:0:0:0:0:0:1
        System.out.println("request.getRemotePort() =" + request.getRemotePort()); // 54305
        System.out.println();

        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName()); // localhost
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //  0:0:0:0:0:0:0:1
        System.out.println("request.getLocalPort() = " + request.getLocalPort()); // 8080

        System.out.println("--- 기타 조회 end ---");
        System.out.println();

    }

}


