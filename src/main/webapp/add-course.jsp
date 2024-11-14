<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Course</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    

    <div class="container my-3">
    <jsp:include page="/header.jsp" />
        <h2>Add New Course</h2>
        <form action="addCourse" method="post">
        <!-- Hidden field for course ID -->
        <input type="hidden" name="id" value="${course.id}" />
        
        <div class="form-group">
            <label for="courseName">CourseName</label>
            <input type="text" class="form-control" name="courseName" required />
        </div>
        
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" class="form-control" name="description"  required />
        </div>
        <div class="form-group">
            <label for="schedule">Schedule</label>
            <input type="text" class="form-control" name="schedule"  />
        </div>
        
        <button type="submit" class="btn btn-primary">Add Course</button>
        <a href="courses" class="btn btn-secondary">Cancel</a>
    </form>
    </div>
</body>
</html>
