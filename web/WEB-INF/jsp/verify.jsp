<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.guidesound.models.Video" %>
<%@ page import="com.guidesound.util.SignMap" %>
<%@ page import="com.guidesound.util.ToolsFunction" %>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="/statics/css/style.css"/>
    <title>视频审核</title>
</head>
<body>


<%
    List<Video> temp = (List<Video>) request.getAttribute("video_list");

%>


<div class="container">
    <div class="course-list">
        <div class="moco-course-list">

            <%
                if (temp != null && temp.size() > 0) {
                    for (Video video : temp) {%>
            <div class="course-card-container">
                <a target="_blank" href="/learn/556" class="course-card">
                    <div class="course-card-top">
                        <img class="course-banner lazy"
                             data-original="<% out.print(video.getPic_up_path());%>"
                             src="<% out.print(video.getPic_up_path());%>" style="display: inline;">
                        <div class="course-label">
                            <label>Angular</label>
                            <label>Node.js</label>
                        </div>
                    </div>
                    <div class="course-card-content">
                        <h3><%out.print("标题:" + video.getTitle());%></h3>
                        <h4><% out.print("科目:" + SignMap.getSubjectById(video.getSubject())); %></h4>
                        <h4><%out.print("观看类型:" + SignMap.getSubjectById(video.getWatch_type()));%></h4>
                        <h4><%out.print("上传时间:" + ToolsFunction.timeStamp2Date(String.valueOf(video.getCreate_time()),null));%></h4>
                    </div>
                </a>
            </div>

            <%}}%>

        </div>
    </div>

</body>
</html>