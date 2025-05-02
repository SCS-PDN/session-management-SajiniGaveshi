src/main/webapp/dashboard.jsp


<div style="background: #f0f0f0; padding: 10px; margin-bottom: 20px;">
    <a href="dashboard" style="margin-right: 15px;">Dashboard</a>
    <a href="logout" style="color: red;">Logout</a>
</div>

<h2>Available Courses</h2>


<h2>Available Courses</h2>
<table>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.instructor}</td>
            <td>
              
                <a href="enroll?courseId=${course.id}">Enroll</a>
            </td>
        </tr>
    </c:forEach>
</table>


<c:if test="${not empty enrolledCourses}">
    <h2>Your Enrolled Courses</h2>
    <ul>
        <c:forEach items="${enrolledCourses}" var="course">
            <li>${course.name} (${course.id})</li>
        </c:forEach>
    </ul>
</c:if>
