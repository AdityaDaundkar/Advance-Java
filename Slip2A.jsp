<%@ page language="java" %>

<html>

    <body>

        <%

            int n = Integer.parseInt(request.getParameter("no"));

            int n1=0;

            for(int i=1; i<n; i++){

                if(n%i==0){

                    n1+=i;

                }

            }

            if(n1==n){

                out.println("Perfect Number");

            }else{

                out.println("not Perfect Number");

            }

        %>

    </body>

</html>

