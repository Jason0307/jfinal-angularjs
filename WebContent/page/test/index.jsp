<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Model List</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/flexigrid.pack.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jqModal_gray.css" />
</head>
<body>
<table id="table_list" style="display: none"></table>
 <div class="jqmWindow" style="width: 300px;" id="modelWin">
			<div class="drag">
				Model Info
				<div class="close"></div>
			</div>
			<form id="saveModel" method="post">
			    <input type="hidden" name="userId">
				<table width="252" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td>Username：</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password：</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>Email：</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>Icon：</td>
						<td><input type="text" name="icon"></td>
					</tr>
				</table>
				<div align="center">
					<input type="button" id="submit" class="input-button" value="提交" />
					<input type="reset" class="input-button" value="重置" />
				</div>
			</form>
		</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/dimensions.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jqDnR.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jqModal.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/flexigrid.pack.js"></script>
<script type="text/javascript">
var arr = '${requestScope.attrs}'.split(",");
var colModelArr = new Array(arr.length);
var searchItems = new Array(arr.length);
function ColModel(display,name,width,sortable,align){
    this.display = display;
    this.name = name;
    this.width = width;
    this.sortable = sortable;
    this.align = align  
}
function SearchItem(display,name,isDefault){
	this.display = display;
	this.name = name;
	this.isDefault = isDefault;
}
for(var i = 0 ; i < arr.length; i++){
	 var display = arr[i].substr(0,1).toUpperCase() + arr[i].substr(1);
	 var cModel = new ColModel(display,arr[i],'100',true,'center');
	 var sItem = new SearchItem(display,arr[i],'true');
	 colModelArr[i] = cModel;
	 searchItems[i] = sItem;
}
$("#table_list").flexigrid({
    url : '<%=request.getContextPath() %>/test/list',
    dataType : 'json',
    colModel : colModelArr,
    buttons : [ {
        name : 'Add',
        bclass : 'add',
        onpress : action
        },
        {
            name : 'Edit',
            bclass : 'edit',
            onpress : action
        },
        {
            name : 'Delete',
            bclass : 'delete',
            onpress : action
        }, {
            separator : true
    } ],
    searchitems : searchItems,
    sortname : arr[0],
    sortorder : "asc",
    usepager : true,
    singleSelect: true,
    title : 'Model',
    useRp : true,
    rp : 15,
    showTableToggleBtn : true,
    width : 700,
    height : 400
});      

var actions="";
function action(com, grid) {
    switch (com) {
	    case 'Add' :
		    $("#saveModel input[type='text']").each(function() {
			        $(this).val("");
		        });
		    $("#saveModel input[type='password']").each(function(){
		    	 $(this).val("");
		    })
		     $('#saveModel').attr("action","add.action");
		    actions="<%=request.getContextPath()%>/user/add";
		    $("#modelWin").jqmShow();
		    break;
	    case 'Edit' :
		    selected_count = $('.trSelected', grid).length;
		    if (selected_count == 0) {
			    alert('Please select one record!');
			    return;
		    }
		    if (selected_count > 1) {
			    alert('Sorry,you can only edit one record at one time!');
			    return;
		    }
		    data = {};
		    $('.trSelected td', grid).each(function(i) {
		    	    var attrName = $(this).attr("abbr");
			        data[attrName] = $(this).children('div').text();
		        });
		    $('#saveModel input[name="userId"]').val(data["userId"]);
		    $('#saveModel input[name="password"]').val(data["password"]).attr("readonly","readonly");
		    $('#saveModel input[name="username"]').val(data["username"]);
		    $('#saveModel input[name="email"]').val(data["email"]);
		    $('#saveModel input[name="icon"]').val(data["icon"]);
		    actions="<%=request.getContextPath()%>/user/update";
		    $("#modelWin").jqmShow();
		    break;
	    case 'Delete' :
		    selected_count = $('.trSelected', grid).length;
		    if (selected_count == 0) {
			    alert('Please select one record!');
			    return;
		    }
		    names = '';
		    $('.trSelected td:nth-child(2) div', grid).each(function(i) {
			        if (i)
				        names += ',';
			        names += $(this).text();
		        });
		    ids = '';
		    $('.trSelected td:nth-child(1) div', grid).each(function(i) {
			        if (i)
				        ids += ',';
			        ids += $(this).text();
		        })
		    if (confirm("Are you sure to delete [" + names + "]?")) {
			    delUser(ids);
		    }
		    break;
    }
}
$("#modelWin").jqm({
    modal : true,
    overlay : 60 
  }).jqmAddClose(".close").jqDrag(".drag");

function delUser(ids) {
    $.ajax({
	        url : '<%=request.getContextPath()%>/user/delete',
	        data : {
		        ids : ids
	        },
	        type : 'POST',
	        dataType : 'json',
	        success : function() {
		        $('#table_list').flexReload();
	        }
        });
}
$("#submit").click(function(){
	 $.ajax({
	        url : actions,
	        data : $("#saveModel").serialize(),
	        type : 'POST',
	        dataType : 'json',
	        success : function(data) {
		    	$("#modelWin").jqmHide();
		        $('#table_list').flexReload();
	        }
        });
});
</script>
</body>
</html>