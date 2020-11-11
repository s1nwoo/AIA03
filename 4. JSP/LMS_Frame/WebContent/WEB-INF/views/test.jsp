<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>






<div id="leftMenu">
	<h3>개설강좌 목록</h3>
	<table class="classList">
		<caption>
			<span>목록</span>
		</caption>
		<thead>
			<tr>
				<th>강의번호</th>
				<th>강의명</th>
				<th>교수명</th>
				<th>학년</th>
				<th>이수구분</th>
				<th>수업시간</th>
				<th>정원</th>
				<th>강의정보</th>
				<th>신청</th>
			</tr>
		</thead>
		<c:if test="${List.size() == 0 }">
			<tfoot>
				<tr>
					<td colspan="9">현재 개설과목이 없습니다.</td>
				</tr>
			</tfoot>

		</c:if>
		<tbody>
			<c:forEach var="result" items="${List}" varStatus="status">
				<tr>
					<td><c:out value="${class.cIdx}" /></td>
					<td><c:out value="${class.name}" /></td>
					<td><c:out value="${class.teacher}" /></td>
					<td><c:out value="${class.grade}" /></td>
					<td><c:out value="${class.category}" /></td>
					<td><c:out
							value="${class.day} ${class.startTime} ${class.endTime}" /></td>
					<td><c:out value="${class.applyPer}/${class.totalPer}" /></td>
					<td><c:out value="강의정보 파일" /></td>
					<td><c:out value="" /> <!-- <button type="button" class="classDelete">+</button> -->
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




</div>
<!-- leftMenu end-->




<div id="contents">
	<h3>일정표</h3>
	<table class="classTable">
		<thead>
			<tr>
				<th>.</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
		</thead>

		<c:if test="${classList.size() == 0 }">
			<tfoot>
				<tr>
					<td colspan="9">현재 개설과목이 없습니다.</td>
				</tr>
			</tfoot>

		</c:if>
		<tbody>
			<c:forEach var="result" items="${classList}" varStatus="status">
				<tr>
					<td><c:out value="${classList.cIdx}" /></td>
					<td><c:out value="${classList.name}" /></td>
					<td><c:out value="${classList.teacher}" /></td>
					<td><c:out value="${classList.grade}" /></td>
					<td><c:out value="${classList.category}" /></td>
					<td><c:out
							value="${classList.day} ${classList.startTime} ${classList.endTime}" /></td>
					<td><c:out value="${classList.applyPer}/${classList.totalPer}" /></td>
					<td><c:out value="강의정보 파일" /></td>
					<td><c:out
							value="
									<button type="button" class="classDelete">+</button>" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
<!-- contents end -->










<div id="footer">
	<h1>footer</h1>
</div>
</div>




</body>

</html>
