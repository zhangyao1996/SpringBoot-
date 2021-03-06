<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>科室列表</title>
        <link rel="stylesheet" href="../css/index.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
    <body>
       <header>
            <div class="container">
               <nav>
                 <a href="/hospital/category/list.do" >分类</a>
                 
             <c:forEach items="${categorys}" var="category">
                  <a href="/hospital/dept/list.do?categoryId=${category.id}" >${category.name}</a>
             </c:forEach>
                </nav>
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>科室</h1>
                    <p>科室列表</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                       <th>名称</th>
                        <th>分类</th>
                        <th>创建时间</th>
                        <th>最后修改时间</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${deptByCategoryId}" var="dept">
                            <tr>
                                <td>${dept.name}</td>
                                <td>${dept.categoryId}</td>
                                <td><fmt:formatDate value="${dept.createTime}" pattern="yyyy-MM-dd"/></td>
                                <td><fmt:formatDate value="${dept.updateTime}" pattern="yyyy-MM-dd"/></td>
                                <td>

                                    <a href="/hospital/dept/updatePrompt.do?id=${dept.id}">修改</a>&nbsp;&nbsp;
                                    <a href="/hospital/dept/delete.do?id=${dept.id}">删除</a>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="/hospital/dept/addPrompt.do"><button>新建</button></a>
                </div>
            </div>
              <div class="container">
                <div id="fatie">
                   <a href="javascript:history.go(-1);" ><button>返回</button></a>
                </div>
            </div>
      
        </section>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>
