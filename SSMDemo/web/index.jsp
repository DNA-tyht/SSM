<%--
  User: 脱氧核糖
  Date: 2021/5/29
  Time: 10:45
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>员工列表</title>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
	<script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
	<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="modal.jsp"/>
<div class="container">
	<!--  标题  -->
	<div class="row">
		<div class="col-md-12">
			<h1>SSM-CRUD</h1>
		</div>
	</div>
	<!--  按钮  -->
	<div class="row">
		<div class="col-md-4 col-md-offset-8">
			<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
			<button class="btn btn-danger">删除</button>
		</div>
	</div>
	<!--  表格数据  -->
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="emps_table">
				<thead>
					<tr>
						<th>#</th>
						<th>empName</th>
						<th>gender</th>
						<th>email</th>
						<th>deptName</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
	</div>
	<!--  分页信息  -->
	<div class="row">
		<!--  分页文字信息  -->
		<div class="col-md-6" id="page_info_area"></div>
		<!--  分页条信息  -->
		<div class="col-md-6" id="page_nav_area"></div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		//去首页
		to_page(1);
	});
	function to_page(pn){
		$.ajax({
			url:"${APP_PATH}/emps",
			data:"pn="+pn,
			type:"GET",
			success:function(result){
				build_emps_table(result);
				build_page_info(result);
				build_page_nav(result);
			}
		});
	}
	/**
	 * @Description 解析员工数据
	 * @Return
	 * @Author 脱氧核糖
	 * @Date 2021/6/3 14:34
	 */
	function build_emps_table(result){
		$("#emps_table tbody").empty();
		var emps = result.extend.pageInfo.list;
		$.each(emps,function(index,item){
			var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
			var empIdTd = $("<td></td>").append(item.empId);
			var empNameTd = $("<td></td>").append(item.empName);
			var genderTd = $("<td></td>").append(item.gender === 'M'?"男":"女");
			var emailTd = $("<td></td>").append(item.email);
			var deptNameTd = $("<td></td>").append(item.department.deptName);
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			$("<tr></tr>").append(checkBoxTd)
					.append(empIdTd)
					.append(empNameTd)
					.append(genderTd)
					.append(emailTd)
					.append(deptNameTd)
					.append(btnTd)
					.appendTo("#emps_table tbody");
		});
	}
	/**
	 * @Description 解析分页信息
	 * @Return
	 * @Author 脱氧核糖
	 * @Date 2021/6/3 14:37
	 */
	function build_page_info(result) {
		$("#page_info_area").empty();
		var pageInfo = result.extend.pageInfo;
		$("#page_info_area").append("当前 " + pageInfo.pageNum + " 页," +
				"总 " + pageInfo.pages + " 页," +
				"总 " + pageInfo.total + " 条记录");
	}
	/**
	 * @Description 解析分页条
	 * @Return
	 * @Author 脱氧核糖
	 * @Date 2021/6/3 13:57
	 */
	function build_page_nav(result) {
		$("#page_nav_area").empty();
		var pageInfo = result.extend.pageInfo;
		var ul = $("<ul></ul>").addClass("pagination");
		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
		var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
		if (pageInfo.hasPreviousPage === false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			//添加单击事件
			firstPageLi.click(function () {
				to_page(1);
			});
			prePageLi.click(function () {
				to_page(pageInfo.pageNum - 1);
			});
		}
		var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
		if (pageInfo.hasNextPage === false) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			//添加单击事件
			nextPageLi.click(function () {
				to_page(pageInfo.pageNum + 1);
			});
			lastPageLi.click(function () {
				to_page(pageInfo.pages);
			});
		}
		ul.append(firstPageLi).append(prePageLi);

		$.each(pageInfo.navigatepageNums, function (index, item) {
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if(pageInfo.pageNum === item){
				numLi.addClass("active");
			}
			numLi.click(function () {
				to_page(item);
			});
			ul.append(numLi);
		});
		ul.append(nextPageLi).append(lastPageLi);
		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav_area");
	}
	/**
	* @Description 点击新增按钮弹出模态框
	* @Return
	* @Author 脱氧核糖
	* @Date 2021/6/3 15:45
	*/
	$("#emp_add_modal_btn").click(function () {
		$("#empAddModal form")[0].reset();
		getDepts();
		$("#empAddModal").modal({
			backdrop:"static"
		});
	});
	/**
	* @Description 获取所有的部门信息
	* @Return
	* @Author 脱氧核糖
	* @Date 2021/6/3 15:56
	*/
	function getDepts() {
		$.ajax({
			url:"${APP_PATH}/depts",
			type:"GET",
			success:function (result) {
				$.each(result.extend.depts, function() {
					var optionEle = $("<option></option>").append(this.deptName).attr("value", this.deptId);
					optionEle.appendTo("#dept_add_select");
				})
			}
		});
	}
	/**
	* @Description 显示校验信息
	* @Return
	* @Author 脱氧核糖
	* @Date 2021/6/3 19:32
	*/
	function show_validate_msg(ele, status, msg) {
		//清除当前元素的校验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text("");
		if("success"=== status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
		}else if("error" === status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	}
	/**
	* @Description 校验表单数据
	* @Return
	* @Author 脱氧核糖
	* @Date 2021/6/3 19:10
	*/
	function validate_add_form() {
		var empName = $("#empName_add_input").val();
		var regName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]+$)/;
		if (!regName.test(empName)) {
			show_validate_msg("#empName_add_input", "error", "用户名是2-5位中文或6-16位英文和数字的组合！");
			return false;
		} else {
			show_validate_msg("#empName_add_input", "success", "");
		}

		var email = $("#email_add_input").val();
		var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if(!regEmail.test(email)) {
			show_validate_msg("#empName_add_input", "error", "邮箱格式错误！")
			return false;
		} else {
			show_validate_msg("#empName_add_input", "success", "");
		}
	}
	/**
	* @Description 校验用户名是否可用
	* @Return
	* @Author 脱氧核糖
	* @Date 2021/6/3 19:36
	*/
	$("#empName_add_input").change(function () {
		var empName = this.value;
		$.ajax({
			url:"${APP_PATH}/checkUser",
			data:"empName=" + empName,
			type:"POST",
			success:function (result) {
				if (result.code === 100) {
					show_validate_msg("#empName_add_input", "success", "用户名可用！");
					$("#emp_save_btn").attr("ajax-va", "success");
				} else {
					show_validate_msg("#empName_add_input", "error", "用户名不可用！");
					$("#emp_save_btn").attr("ajax-va", "error");
				}
			}
		});
	});
	/**
	* @Description 保存新增操作
	* @Return
	* @Author 脱氧核糖
	* @Date 2021/6/3 16:20
	*/
	$("#emp_save_btn").click(function () {
		if (!validate_add_form()) {
			return false;
		}
		if ($(this).attr("ajax-va") === "error") {
			return false;
		}
		$.ajax({
			url:"${APP_PATH}/emp",
			type:"POST",
			data:$("#dept_add_select").serialize(),
			success:function (result) {
				$("#empAddModal").modal('hide');
				to_page(999);
			}
		});
	});
</script>
</body>
</html>