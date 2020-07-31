# jetty-dojo

Clone the project to local, then import it to eclipse as maven project. Then directly run App.java under zz.jettytest in eclipse. This application need a backend server runs on localhost:7777, I use a servlet with url "http://localhost:7777" to mock it.

The zz.jettytest.HelloProxyServlet (url mapping /hello) is the code I override getHttpClient method, the origin code is zz.jettytest.HelloProxyServlet2 (url mapping /hello2). 
So send a request "http://localhost:7070/hello1?1", then quickly send a second request "http://localhost:7070/hello?2", the secode request will respond immediately.
But send a request to old implement "http://localhost:7070/hello2?1", then a second request "http://localhost:7070/hello2?2", the secode request will response after 1st request is finished.


