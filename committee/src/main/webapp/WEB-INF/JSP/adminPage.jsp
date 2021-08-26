<%--
  Created by IntelliJ IDEA.
  User: Seregi4
  Date: 20.05.2021
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<style>
    <%@include file='/WEB-INF/CSS/admin.css' %>
</style>
<head>
    <title>Admin panel</title>
</head>
<body>
<div class="table">
    <div class="left-panel">
        <div class="button-add">
            <form action="/admin" method="post">
                <input value="0" style="display: none">
                <button name="new-faculty" type="submit">New faculty</button>
            </form>
        </div>
        <c:forEach items="${list}" var="item">
            <div class="faculty">
                <form action="/admin" method="post">
                    <input name="open-faculty" value="<c:out value="${item.getId()}"/>" readonly>
                    <button type="submit"><c:out value="${item.getName()}"/></button>
                </form>
            </div>
        </c:forEach>
        <form action="/admin" method="post">
            <input value="0" style="display: none">
            <button class="button-home" name="home" type="submit">Back</button>
        </form>
    </div>

    <div class="right-panel">

        <c:if test="${new1 != null}">

            <div class="block-second">
                <div class="block-second-left">
                    <form class="edit-form" action="/admin" method="post">
                        <div class="name">
                            <div class="fac-name">Faculty name:</div>
                            <input name="new-name" type="text">
                        </div>

                        <div class="description">
                            <div class="desc-name">Description:</div>
                            <div class="value-desc"><textarea name="new-description"> </textarea></div>
                        </div>
                        <button type="submit">Save</button>
                    </form>
                </div>

            </div>
        </c:if>

        <c:if test="${edit != null}">
        <div class="block-one">
            <div class="button-add-spec">
                <form action="/admin" method="post">
                    <input name="add-speciality" value="${fac.getId()}" readonly style="display: none">
                    <button type="submit">Add a specialty</button>
                </form>
            </div>
            <div class="button-delete-fuc">
                <form action="/admin" method="post">
                    <input name="delete" value="${fac.getId()}" readonly style="display: none">
                    <button type="submit">Delete Faculty</button>
                </form>
            </div>
            <div class="button-edit-fuc">
                <form action="/admin" method="post">
                    <input name="edit" value="${fac.getId()}" readonly style="display: none">
                    <button type="submit">Edit Faculty</button>
                </form>
            </div>
        </div>

        <div class="block-second">
            <div class="block-second-left">
                <form class="edit-form" action="/admin" method="post">
                    <div class="name">
                        <input name="edit-name" type="text" value="${fac.getName()}">
                    </div>

                    <div class="description">
                        <div class="fac-desc">Description:</div>
                        <div class="fac-desc-edit"><textarea
                                name="edit-description">${fac.getDescription()}</textarea></div>
                    </div>
                    <input name="editfac" value="${fac.getId()}" readonly style="display: none">
                    <button type="submit">Save</button>
                </form>
            </div>
            <div class="block-second-right">
                <div>Specialties:</div>
                <div class="block-second-right-list">
                    <c:forEach items="${listspec}" var="spec">
                        <div>
                            <form action="/admin" method="post">
                                <input name="id-spec" value="${spec.getId()}" readonly
                                       style="display: none">
                                <input name="id" value="${fac.getId()}" readonly style="display: none">
                                <button type="submit">${spec.getName()}</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

</div>
</c:if>

<c:if test="${add != null}">
    <div class="block-one">
        <div class="button-add-spec">
            <form action="/admin" method="post">
                <input name="add-speciality" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Add a specialty</button>
            </form>
        </div>
        <div class="button-delete-fuc">
            <form action="/admin" method="post">
                <input name="delete" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Delete Faculty</button>
            </form>
        </div>
        <div class="button-edit-fuc">
            <form action="/admin" method="post">
                <input name="edit" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Edit Faculty</button>
            </form>
        </div>
    </div>


    <div class="block-second">
        <div class="block-second-left">
            <form class="edit-form" action="/admin" method="post">
                <div class="name">
                    <div class="fac-desc">Specialty name:</div>
                    <input name="spec-name" type="text">
                    <input name="number-of-seats" type="text" placeholder="enter number of seats">
                </div>

                    <%--                <div class="description">--%>
                    <%--                    <div class="fac-desc">Description:</div>--%>
                    <%--                    <div class="fac-desc-edit">--%>
                    <%--                        <textarea name="spec-description"></textarea>--%>
                    <%--                    </div>--%>
                    <%--                </div>--%>
                <input name="id" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Save</button>
            </form>
        </div>
        <div class="block-second-right">
            <div>Specialties:</div>
            <div class="block-second-right-list">
                <c:forEach items="${listspec}" var="spec">
                    <div>
                        <form action="/admin" method="post">
                            <input name="id-spec" value="${spec.getId()}" readonly
                                   style="display: none">
                            <input name="id" value="${fac.getId()}" readonly style="display: none">
                            <button type="submit">${spec.getName()}</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
</c:if>

<c:if test="${facult != null}">
    <div class="block-one">
        <div class="button-add-spec">
            <form action="/admin" method="post">
                <input name="add-speciality" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Add a specialty</button>
            </form>
        </div>
        <div class="button-delete-fuc">
            <form action="/admin" method="post">
                <input name="delete" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Delete Faculty</button>
            </form>
        </div>
        <div class="button-edit-fuc">
            <form action="/admin" method="post">
                <input name="edit" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Edit Faculty</button>
            </form>
        </div>
    </div>
    <div class="block-second">
        <div class="block-second-left">
            <div class="name"><h2><c:out value="${fac.getName()}"/></h2></div>
            <div class="description">
                <div class="desc-name">Description:</div>
                <div class="value-desc"><c:out value="${fac.getDescription()}"/></div>
            </div>
        </div>
        <div class="block-second-right">
            <div>Specialties:</div>
            <div class="block-second-right-list">
                <c:forEach items="${listspec}" var="spec">
                    <div>
                        <form action="/admin" method="post">
                            <input name="id-spec" value="${spec.getId()}" readonly style="display: none">
                            <input name="id" value="${fac.getId()}" readonly style="display: none">
                            <button type="submit">${spec.getName()}</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
    </div>
</c:if>

<c:if test="${speciality != null}">

    <div class="block-one">
        <div class="button-add-spec">
            <form action="/admin" method="post">
                <input name="add-speciality" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Add a specialty</button>
            </form>
        </div>
        <div class="button-delete-fuc">
            <form action="/admin" method="post">
                <input name="delete" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Delete Faculty</button>
            </form>
        </div>
        <div class="button-edit-fuc">
            <form action="/admin" method="post">
                <input name="edit" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Edit Faculty</button>
            </form>
        </div>
    </div>

    <div class="block-second">
        <div class="block-second-left">
            <div class="link-to-back">
                <form action="/admin" method="post">
                    <input name="open-faculty" readonly value="${fac.getId()}" style="display: none">
                    <button type="submit">${fac.getName()}</button>
                </form>
            </div>

            <div class="bar-specialty">
                <div class="edit-specialty-button">
                    <form action="/admin" method="post">
                        <input name="edit-specialty" readonly value="${spec.getId()}"
                               style="display: none">
                        <input name="id-faculty" readonly value="${fac.getId()}" style="display: none">
                        <button type="submit">Edit Specialty</button>
                    </form>
                </div>
                <div class="delete-specialty-button">
                    <form action="/admin" method="post">
                        <input name="delete-specialty" readonly value="${spec.getId()}"
                               style="display: none">
                        <input name="id-faculty" readonly value="${fac.getId()}" style="display: none">
                        <button type="submit">Delete Specialty</button>
                    </form>
                </div>

                <div class="button-add-examination-discipline">
                    <form action="/admin" method="post">
                        <input name="id" readonly value="${fac.getId()}" style="display: none">
                        <input name="add-examination-discipline" value="${spec.getId()}" readonly style="display: none">
                        <button type="submit">Add a examination discipline</button>
                    </form>
                </div>

            </div>
            <div class="name-spec"><h3>${spec.getName()}</h3></div>
                <%--            <div class="description">--%>
                <%--                <div class="desc-name">Description:</div>--%>
                <%--                <div class="value-desc">${spec.getDescription()}</div>--%>
                <%--            </div>--%>
            <div class="list-disciplin">
                <c:forEach items="${listdiscip}" var="discipline">
                    <div>${discipline.getName()}</div>
                </c:forEach>
            </div>
        </div>
        <div class="block-second-right">
            <div>Specialties:</div>
            <div class="block-second-right-list">
                <c:forEach items="${listspec}" var="spec">
                    <div>
                        <form action="/admin" method="post">
                            <input name="id-spec" value="${spec.getId()}" readonly
                                   style="display: none">
                            <input name="id" value="${fac.getId()}" readonly style="display: none">
                            <button type="submit">${spec.getName()}</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>

</c:if>

<c:if test="${editspecialty != null}">

    <div class="block-one">
        <div class="button-add-spec">
            <form action="/admin" method="post">
                <input name="add-speciality" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Add a specialty</button>
            </form>
        </div>
        <div class="button-delete-fuc">
            <form action="/admin" method="post">
                <input name="delete" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Delete Faculty</button>
            </form>
        </div>
        <div class="button-edit-fuc">
            <form action="/admin" method="post">
                <input name="edit" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Edit Faculty</button>
            </form>
        </div>
    </div>


    <div class="block-second">
        <div class="block-second-left">
            <div class="link-to-back">
                <form action="/admin" method="post">
                    <input name="open-faculty" readonly value="${fac.getId()}" style="display: none">
                    <button type="submit">${fac.getName()}</button>
                </form>
            </div>

            <div class="bar-specialty">
                <div class="edit-specialty-button">
                    <form action="/admin" method="post">
                        <input name="edit-specialty" readonly value="${spec.getId()}"
                               style="display: none">
                        <input name="id-faculty" readonly value="${fac.getId()}" style="display: none">
                        <button type="submit">Edit Specialty</button>
                    </form>
                </div>
                <div class="delete-specialty-button">
                    <form action="/admin" method="post">
                        <input name="delete-specialty" readonly value="${spec.getId()}"
                               style="display: none">
                        <input name="id-faculty" readonly value="${fac.getId()}" style="display: none">
                        <button type="submit">Delete Specialty</button>
                    </form>
                </div>
            </div>
            <div>
                <form class="edit-form" action="/admin" method="post">
                    <div class="name-spec">
                        <div>Name specialty:</div>
                        <input name="edit-spec-name" type="text" value="${spec.getName()}"></div>
                    <input name="edit-number-of-seats" type="text value="${numberOfSeats}">
                    <input name="id" value="${fac.getId()}" readonly style="display: none">
                    <input name="id-spec" value="${spec.getId()}" readonly style="display: none">
                    <button type="submit">Save</button>
                </form>
            </div>

        </div>
        <div class="block-second-right">
            <div>Specialties:</div>
            <div class="block-second-right-list">
                <c:forEach items="${listspec}" var="spec">
                    <div>
                        <form action="/admin" method="post">
                            <input name="id-spec" value="${spec.getId()}" readonly
                                   style="display: none">
                            <input name="id" value="${fac.getId()}" readonly style="display: none">
                            <button type="submit">${spec.getName()}</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>

</c:if>

<c:if test="${discipline != null}">

    <div class="block-one">
        <div class="button-add-spec">
            <form action="/admin" method="post">
                <input name="add-speciality" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Add a specialty</button>
            </form>
        </div>
        <div class="button-delete-fuc">
            <form action="/admin" method="post">
                <input name="delete" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Delete Faculty</button>
            </form>
        </div>
        <div class="button-edit-fuc">
            <form action="/admin" method="post">
                <input name="edit" value="${fac.getId()}" readonly style="display: none">
                <button type="submit">Edit Faculty</button>
            </form>
        </div>
    </div>


    <div class="block-second">
        <div class="block-second-left">
            <div class="link-to-back">
                <form action="/admin" method="post">
                    <input name="open-faculty" readonly value="${fac.getId()}" style="display: none">
                    <button type="submit">${fac.getName()}</button>
                </form>
            </div>

            <div class="bar-specialty">
                <div class="edit-specialty-button">
                    <form action="/admin" method="post">
                        <input name="edit-specialty" readonly value="${spec.getId()}"
                               style="display: none">
                        <input name="id-faculty" readonly value="${fac.getId()}" style="display: none">
                        <button type="submit">Edit Specialty</button>
                    </form>
                </div>
                <div class="delete-specialty-button">
                    <form action="/admin" method="post">
                        <input name="delete-specialty" readonly value="${spec.getId()}"
                               style="display: none">
                        <input name="id-faculty" readonly value="${fac.getId()}" style="display: none">
                        <button type="submit">Delete Specialty</button>
                    </form>
                </div>
            </div>
            <div>
                <form class="edit-form" action="/admin" method="post">
                    <div class="name-discip"></div>
                    <div>Enter discipline name</div>
                    <input name="disciplin-name" type="text">
                    <input name="spec-id" readonly value="${spec.getId()}"
                           style="display: none">
                    <button type="submit">Save</button>
                </form>
            </div>

        </div>
        <div class="block-second-right">
            <div>Specialties:</div>
            <div class="block-second-right-list">
                <c:forEach items="${listspec}" var="spec">
                    <div>
                        <form action="/admin" method="post">
                            <input name="id-spec" value="${spec.getId()}" readonly
                                   style="display: none">
                            <input name="id" value="${fac.getId()}" readonly style="display: none">
                            <button type="submit">${spec.getName()}</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>

</c:if>
<c:if test="${cc != null}">
    <div style="width: 100%; height: 100%; font-size: 30px; display: flex; justify-content: center;
align-items: center; text-align: center; font-weight: 700">Nothing selected
    </div>
</c:if>
</div>
</div>
</body>
</html>
