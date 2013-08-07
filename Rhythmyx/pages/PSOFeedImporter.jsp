<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
	
	<%
	String cid=request.getParameter("sys_contentid");
	String fid=request.getParameter("sys_folderid");
	%>
<html>
<head>
<title>Loading Feed...</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script type="text/javascript">
  $(function(){
        $.ajax({
        type: "GET",
        url: "/Rhythmyx/services/Content/importfeed?debug=false&sys_contentid=<%=cid%>&sys_folderid=<%=fid%>",
        complete: function(xhr, status) {
         	window.opener.location.reload();
            window.close();
        }
 
        });
  });
</script>
</head>
<body>
<div align="center">
<img src="/Rhythmyx/rx_resources/images/pso-loader.gif" alt="Loading Feed..." align="middle"/>
</div>
</body>
</html>