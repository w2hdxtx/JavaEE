<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>员工信息管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="static/css/bootstrap.min.css" />
	<script type="text/javascript" src="static/js/jquery-1.11.0.js" ></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js" ></script>
	
	<style type="text/css">
		#title {
			  margin-top: 4px;
			  margin-bottom: 4px;
			}
	</style>
	
</head>
<body>
	<!-- 新增员工模态框-->
	<div class="modal fade" id="add_emp_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	   	
	   	<!-- 模态框的标题部分-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">员工添加</h4>
	      </div>
	      
	      <!-- 模态框的正文-->
	      <div class="modal-body">
	      	<form class="form-horizontal" id="add_emp_form">
			  <div class="form-group">
			    <label for="lastName" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="lastName" id="lastName" placeholder="lastName">
			       <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="email" class="col-sm-2 control-label">邮箱</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="email" id="email" placeholder="xxx@example.com">
			       <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			  	<label  class="col-sm-2 control-label">性别</label>
			   	<div class="col-sm-8">
			   		<label class="radio-inline">
				  		<input type="radio" name="gender" value="1" checked="checked"> 男
					</label>
					<label class="radio-inline">
				 		<input type="radio" name="gender" value="0"> 女
					</label>
			   </div>
			  </div>
			  <div class="form-group">
			  	<label for="deptId" class="col-sm-2 control-label">部门</label>
			    <div class="col-sm-3">
			    	<select class="form-control" name="deptId" id="deptId">
					</select>
			    </div>
			  </div>
			</form>
	      </div>
	       
	      	<!-- 模态框的尾部-->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="save_emp_btn" >保存</button>
	      </div>
	      
	    </div>
	  </div>
	</div>

	
	
	
	<!-- 员工修改模态框-->
	<div class="modal fade" id="edit_emp_modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	   	
	   	<!-- 模态框的标题部分-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">员工信息修改</h4>
	      </div>
	      
	      <!-- 模态框的正文-->
	      <div class="modal-body">
	      	<form class="form-horizontal" id="edit_emp_form">
			  <div class="form-group">
			    <label for="lastName" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="lastName" id="lastName" placeholder="lastName" readonly value="xxx">
			       <span class="help-block"></span>
			       <input type="hidden" name="id">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="email" class="col-sm-2 control-label">邮箱</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="email" id="email" placeholder="xxx@example.com">
			       <span class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			  	<label  class="col-sm-2 control-label">性别</label>
			   	<div class="col-sm-8">
			   		<label class="radio-inline">
				  		<input type="radio" name="gender" value="1" checked="checked"> 男
					</label>
					<label class="radio-inline">
				 		<input type="radio" name="gender" value="0"> 女
					</label>
			   </div>
			  </div>
			  <div class="form-group">
			  	<label for="deptId" class="col-sm-2 control-label">部门</label>
			    <div class="col-sm-3">
			    	<select class="form-control" name="deptId" id="deptId">
					</select>
			    </div>
			  </div>
			</form>
	      </div>
	       
	      	<!-- 模态框的尾部-->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary" id="edit_modal_save_emp_btn" >保存</button>
	      </div>
	      
	    </div>
	  </div>
	</div>



	<!-- 显示员工信息-->
	<div class="container">
		
		<!-- 页面的标题栏 -->
		<div class="row">
			<h1>SSM-CRUD</h1>
		</div>
		<!-- 新增员工和批量删除的按钮 -->
		<div class="row" id="title">
			<div class="col-md-2 col-md-offset-9">
				<button  class="btn btn-primary" id="add_emp_btn">
					<span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 添加
				</button>
				<button class="btn btn-danger" id="delete_emp_btn">
					<span class="glyphicon glyphicon-trash" aria-hidden="true" ></span> 删除
				</button>
			</div>
			
		</div>
		
		<!-- 显示员工信息的表单 -->
		<div class="row" >
			<table class="table table-striped table-hover" id="listEmpsTable" >
				<tbody>
				</tbody>
			</table>
		</div>
		
		<!-- 页面底部的分页条 -->
		<div class="row" id="pageDivideDiv" >
		</div>
	</div>
	
	
	
	
	<script type="text/javascript">
	
	var currentPageNum = 1;   //当前页码，用于编辑用户后跳转到当前页
	
		$(function() {
			
			toPage(1);		//页面加载完成时查询第一页员工信息进行显示
			bindClick();   //给各个按钮添加绑定事件
			
		})
		
		
		//根据传入的页码跳到指定页
		function toPage(pageNum) {
			
			$.ajax({
				url:"${pageContext.request.contextPath}/emps",
				type:"GET",
				data:{
					"pageNum":pageNum
				},
				success:function(result){
					
					//每次显示员工信息之前，清空以前的信息
					var $tbody = $("#listEmpsTable tbody");   
					$tbody.empty();
					
					//创建员工信息的标题栏
					$("<tr />").append($("<th />").append("#")).append($("<th />").append("编号")).append($("<th />").append("姓名"))
						.append($("<th />").append("邮箱")).append($("<th />").append("性别")).append($("<th />").append("部门"))
						.append($("<th />").append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作")).appendTo($tbody);
					
					//遍历员工信息的集合，创建出表格
					var emps = result.map.pageInfo.list;
					var currentPageNum = result.map.pageInfo.pageNum;
					$.each(emps,function(index, item){
						
						var $checkbox = $("<input type='checkbox' />");
						$checkbox.attr("empId",item.id);
						
						var $checkboxTd = $("<td />").append($checkbox);
						
						var $idTd = $("<td />").append(item.id);
						var $lastNameTd = $("<td />").append(item.lastName);
						var $emailTd = $("<td />").append(item.email);
						var $genderTd = $("<td />").append(item.gender == "0"?"女":"男");
						var $departmentTd = $("<td />").append(item.department.departmentName);
						
						var $buttonTd = $("<td />");
						
						var $editBtn = $("<button />").addClass("btn btn-primary  btn-sm").append($("<span />").addClass("glyphicon glyphicon-pencil").attr("aria-hidden","true")).append(" 修改");
						var $deleteBtn = $("<button />").addClass("btn btn-danger  btn-sm").append($("<span />").addClass("glyphicon glyphicon-remove").attr("aria-hidden","true")).append(" 删除");
						
						//为删除按钮添加点击事件
						$deleteBtn.click(function() {
							var empId = $(this).parent().parent().find(":checkbox").attr("empId");
							$.ajax({
								url:"${pageContext.request.contextPath}/delete/"+empId,
								type:"DELETE",
								success:function(delResult){
									
									if(delResult.code == 1){
										toPage(currentPageNum);
									}else{
										alert("删除失败："+delResult.message);
									}
								},
							});
							
						});
						
						//为编辑按钮添加点击事件
						$editBtn.click(function() {
							var empId = $(this).parent().parent().find(":checkbox").attr("empId");
							//发送ajax请求获取部门信息填充到模态框的部门下拉选
							$.ajax({
								url:"${pageContext.request.contextPath}/depts",
								type:"GET",
								success:function(result){
									var depts = result.map.depts;
									$("#edit_emp_modal #deptId").empty()
									$.each(depts, function(index, dept) {
										$("<option />").val(dept.id).append(dept.departmentName).appendTo("#edit_emp_modal #deptId");
									});
								}
							});
							$.ajax({                                                    //获取待修改的员工的信息
								url:"${pageContext.request.contextPath}/update",
								data:{"empId":empId},
								type:"GET",
								success:function(empMsg){
									console.log(empMsg);
									if(empMsg.code==1){
										var emp = empMsg.map.emp;
										$("#edit_emp_modal").modal({				//打开员工修改模态框
											backdrop:'static'
										});
										//数据回显
										$("#edit_emp_modal input[name='id']").val(emp.id);
										$("#edit_emp_modal input[name='lastName']").val(emp.lastName);
										$("#edit_emp_modal input[name='email']").val(emp.email);
										$("#edit_emp_modal input[name='gender']").val([emp.gender]);
										$("#edit_emp_modal select").val([emp.department.id]);
									}
								},
							});
						});
						
						
						$buttonTd.append($editBtn).append("  ").append($deleteBtn);
						
						$("<tr />").append($checkboxTd).append($idTd).append($lastNameTd).append($emailTd).append($genderTd).append($departmentTd)
							.append($buttonTd).appendTo($tbody);
						
					});
					
					//清空底部div开的分页条信息
					$("#pageDivideDiv").empty();
					
					//创建底部分页条
					var $h5 = $("<h5 />").append("当前第"+result.map.pageInfo.pageNum+"页， ").append("共"+result.map.pageInfo.pages+"页，")
										 .append("共"+result.map.pageInfo.total+"条记录。");
					currentPageNum = result.map.pageInfo.pageNum;
					
					var $pageMsgDiv = $("<div />").addClass("col-md-4").append($h5);
					
					var $pageBarDiv = $("<div />").addClass("col-md-6 col-md-offset-2");
					var $pageBarNav = $("<nav />").attr("aria-label","Page navigation");
					var $pageBarUl = $("<ul />").addClass("pagination");
					
					//首页、前一页
					var $firstPageLi = $("<li />").attr("pageNum","1").append($("<a />").attr("href","#").text("首页"));
					var $previousPageLi = $("<li />").attr("pageNum",result.map.pageInfo.pageNum-1).append($("<a />").attr("href","#").attr("aria-label","Previous")
							.append($("<span />").attr("aria-hidden","true").append("&laquo;")));
					
					$pageBarUl.append($firstPageLi).append($previousPageLi);
					
					//要连续显示的页数
					var navigatepageNums = result.map.pageInfo.navigatepageNums; 
					$.each(navigatepageNums,function(index, item){
						
						var page = $("<li />").attr("pageNum",item).append($("<a />").attr("href","#").text(item));
						//当前页的按钮添加背景色
						if(item == result.map.pageInfo.pageNum)
							page.addClass("active");
						$pageBarUl.append(page);
						
					});
					
					//下一页、末页
					var $nextPageLi = $("<li />").attr("pageNum",result.map.pageInfo.pageNum+1).append($("<a />").attr("href","#").attr("aria-label","Previous")
							.append($("<span />").attr("aria-hidden","true").append("&raquo;")));
					var $lastPageLi = $("<li />").attr("pageNum",result.map.pageInfo.total).append($("<a />").attr("href","#").text("末页"));
					
					$pageBarUl.append($nextPageLi).append($lastPageLi);
					
					$pageBarNav.append($pageBarUl);
					
					$pageBarDiv.append($pageBarNav);
					
					$("#pageDivideDiv").append($pageMsgDiv).append($pageBarDiv);
					
				}
			});
		}
		
		
		//给各个按钮添加绑定事件
		function bindClick() {
			
			//给分页条上的页码按钮添加点击事件，点击指定页码跳到指定的页
			$(document).on("click","li",function(){
				
				toPage($(this).attr("pageNum"));
			});
			
			//给新增按钮添加点击事件,点击弹出模态框
			$("#add_emp_btn").click(function() {
				//重置模态框中表单元素的value值，防止保存了上次的信息，不会重置class属性值
				$("#add_emp_form")[0].reset();  
				//发送ajax请求获取部门信息填充到模态框的部门下拉选
				$.ajax({
					url:"${pageContext.request.contextPath}/depts",
					type:"GET",
					success:function(result){
						var depts = result.map.depts;
						$.each(depts, function(index, dept) {
							$("<option />").val(dept.id).append(dept.departmentName).appendTo("#add_emp_modal #deptId");
						});
					}
				});
				
				$("#add_emp_modal").modal({		//打开 员工添加模态框，并设置点击背景区域不会关闭模态框
					backdrop:'static'
				});
			});
			
			//给新增员工的模态框的保存按钮添加点击事件
			$("#save_emp_btn").click(function() {
				
				//表单提交前先检查用户名和邮箱是否合法，不合法就触发一次输入框的change事件并直接结束
				if(!checkLastName($("#add_emp_modal #lastName").val())){   
					$("#add_emp_modal #lastName").trigger("change");     //手动触发lastName的change事件
					return;
				}
				if(!checkEmail($("#add_emp_modal #email").val())){
					$("#add_emp_modal #email").trigger("change");     //手动触发email的change事件
					return;
				}
				
				if($("#add_emp_modal #lastName").next("span").attr("lastNameAvaiable") != 1)   //如果用户名后台校验没通过
					return;
		
				//发送ajax保存新增用户
				$.ajax({
					url:"${pageContext.request.contextPath}/emp",
					type:"POST",
					data:$("#add_emp_form").serialize(),
					success:function(result){
						
						if(result.code == 1){		            //后台JSR303检验数据通过，保存成功
							$("#add_emp_modal").modal('hide'); //关闭模态框
							toPage(65535);                      //跳到最后一页（使用了PageHelper的参数合理化属性，页码超过总页码时直接查询最后一页）
						}else{
							                                    //后台JSR303检验数据出错,哪个字段出错就显示对应的出错信息。
							if (result.map.lastName != undefined) {
								$("#add_emp_modal #lastName").parent().removeClass("has-success has-error");
								$("#add_emp_modal #lastName").parent().addClass("has-error");
								$("#add_emp_modal #lastName").next("span").text(result.map.lastName);
								$("#add_emp_modal #lastName").next("span").attr("lastNameAvaiable",0);
							}
							                                    
							if (result.map.email != undefined) {
								$("#add_emp_modal #email").parent().removeClass("has-success has-error");
								$("#add_emp_modal #email").parent().addClass("has-error");
								$("#add_emp_modal #email").next("span").text(result.map.email);
							}
						                                    
						}
					}
				});
			});
			
			
			//员工修改模态框的保存按钮添加点击事件
			$("#edit_modal_save_emp_btn").click(function() {
				
				//修改时只进行了邮箱的前台校验，没进行后台校验
				if(!checkEmail($("#edit_emp_modal #email").val())){
					$("#edit_emp_modal #email").trigger("change");     //手动触发email的change事件
					return;
				}
				
				var empId = $("#edit_emp_modal :hidden").val();
				$.ajax({
					url:"${pageContext.request.contextPath}/update/"+empId,
					data:$("#edit_emp_form").serialize(),
					type:"PUT",
					success:function(result){
						if(result.code == 1){
							$("#edit_emp_modal").modal('hide'); //关闭模态框
							toPage(currentPageNum);
						}
						
					}
				});
				
				
			});
			
			
			//给员工添加模态框的姓名输入框添加change事件检验用户名
			$("#add_emp_modal #lastName").change(function() {
				
				$(this).parent().removeClass("has-success has-error");
				if(!checkLastName($(this).val())){                     //用户名未通过前台校验
					$(this).parent().addClass("has-error");
					$(this).next("span").text("用户名必须是3-12位字母数字组合或者1-4个汉字");
				}else{												//用户名通过前台校验
					//然后进行后台检验
					/**
					* AJAX中jQuery不要使用this，debug发现这里的$(this)代表window对象，不再是绑定事件的那个<input>对象了
					*/
					$.ajax({
						url:"${pageContext.request.contextPath}/validateLastName",
						data:{
							"lastName":$("#add_emp_modal #lastName").val()
							},
						type:"POST",
						success:function(result){
							if(result.code == 1){						//用户名可用
								$("#add_emp_modal #lastName").parent().addClass("has-success");
								$("#add_emp_modal #lastName").next("span").text("");
								$("#add_emp_modal #lastName").next("span").attr("lastNameAvaiable",1); //标记用户名后台校验的结果，1可用，0不可用
							}else{										//用户名已存在
								$("#add_emp_modal #lastName").parent().addClass("has-error");
								$("#add_emp_modal #lastName").next("span").text("用户名已存在");
								$("#add_emp_modal #lastName").next("span").attr("lastNameAvaiable",0);
							}
							
						}
					});
				}
					
			});
			
			
			
			
			//给员工添加模态框的邮箱的输入框添加change事件检验邮箱格式
			$("#add_emp_modal #email").change(function() {
				
				$(this).parent().removeClass("has-success has-error");
				if(!checkEmail($(this).val())){							//邮箱未通过前台校验
					$(this).parent().addClass("has-error");
					$(this).next("span").text("邮箱格式不正确");
				}
				else{													//邮箱通过前台校验
					$(this).parent().addClass("has-success");
					$(this).next("span").text("");
				}
					
			});
			
			//给员工修改模态框的邮箱的输入框添加change事件检验邮箱格式
			$("#edit_emp_modal #email").change(function() {
				
				$(this).parent().removeClass("has-success has-error");
				if(!checkEmail($(this).val())){							//邮箱未通过前台校验
					$(this).parent().addClass("has-error");
					$(this).next("span").text("邮箱格式不正确");
				}
				else{													//邮箱通过前台校验
					$(this).parent().addClass("has-success");
					$(this).next("span").text("");
				}
					
			});
			
			
		}
	
		//校验传入的字符串是否符合姓名格式：true：符合， false：不符合
		function checkLastName(lastName) {
			
			var regName = /(^[a-zA-Z0-9_-]{3,12}$)|(^[\u2E80-\u9FFF]{1,4})$/;
			return regName.test(lastName);
		}
		
		//校验传入的字符串是否符合邮箱格式：true：符合， false：不符合
		function checkEmail(email) {
			
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			return regEmail.test(email);
		}
	
	
	</script>
	
	
	
	
	
</body>
</html>




