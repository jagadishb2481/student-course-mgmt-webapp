<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    

    <div class="container my-3">
    <jsp:include page="/header.jsp" />
        <h2>Add New Student</h2>
        <form action="addStudent" method="post">
        <!-- Hidden field for student ID -->
        <input type="hidden" name="id" value="${student.id}" />
        
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" required />
        </div>
        
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="email"  required />
        </div>
        <div class="form-group">
            <label for="major">Major</label>
            <input type="text" class="form-control" name="major"  />
        </div>
        
        <button type="submit" class="btn btn-primary">Add Student</button>
        <a href="students" class="btn btn-secondary">Cancel</a>
    </form>
    </div>
</body>
</html>
