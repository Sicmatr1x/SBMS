<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Home Page</h1>
	<h3>add base</h3>
	<table border="1">
        <tbody id="base-table"></tbody>
    </table>
	<form id="addBase-form">
		baseName:<input type="text" name="baseName"/><br>
		<input type="button" name="submit" value="add" id="addBase-btn"/><br><br><span name="info-span"></span>
	</form>
	<h3>add item</h3>
	<table border="1">
        <tbody id="item-table"></tbody>
    </table>
    <form id="addItem-form">
		itemName:<input type="text" name="itemName"/><br>
		num:<input type="text" name="num"/><br>
		bid:<input type="text" name="bid"/><br>
		<input type="button" name="submit" value="add" id="addItem-btn"/><br><br><span name="info-span"></span>
	</form>
</body>
<script>
$(document).ready(function(){
    function loadBase(){
        $("#base-table").empty();
        $.ajax({
            url : "/SBMS/base/list",
            type : "get",
            data : null,  
            dataType : "json",
            success : function(data) {
            	console.log(data);
            	
                data.forEach((item,index)=>{
                    	let btn =document.createElement("input");
                    	btn.type="button";
                    	btn.value="DELETE";
                    	$(btn).on("click",(event)=>{deleteBase(item);});
                    	
                        $("#base-table")
                        .append("<tr>")
                        .append($("<td>").text(item.bid))
                        .append($("<td>").text(item.baseName))
                        .append($("<td>").text(item.baseName))
                        //.append($("<select>").attr("id","base-select-"+item.bid)
                        .append(btn)
                        .append("</tr>");
                        
                        
                });
				
            },
            error : function() {
            	$("#addBase-form span[name=info-span]").text("ajax request error");
            	console.log("ajax request error");
            }
        });//end ajax
    }
    
    loadBase();
    
    
	$("#addBase-btn").click(function() {
       
		$.ajax({
            url : "/SBMS/base",
            type : "post",
            data : {
            	baseName:$("#addBase-form input[name=baseName]").val()
            },  
            dataType : "json",
            success : function(data) {
            	console.log(data);
            	loadBase();
                loadItem();
				console.log("data=" + data);
            },
            error : function() {
            	$("#addBase-form span[name=info-span]").text("ajax request error");
            	console.log("ajax request error");
            }
        });//end ajax

    });
    
    $("#addItem-btn").click(function() {
       
		$.ajax({
            url : "/SBMS/item",
            type : "post",
            data : {
            	itemName:$("#addItem-form input[name=itemName]").val(),
                num:$("#addItem-form input[name=num]").val(),
                base:{bid:$("#addItem-form input[name=bid]").val()}
            },  
            dataType : "json",
            success : function(data) {
            	console.log(data);
            	loadBase();
                loadItem();
				console.log("data=" + data);
            },
            error : function() {
            	$("#addBase-form span[name=info-span]").text("ajax request error");
            	console.log("ajax request error");
            }
        });//end ajax

    });
    
    function deleteBase(item){
        console.log(item);
        $.ajax({
            url : "/SBMS/base/"+item.bid,
            type : "delete",
            data :null,  
            dataType : "json",
            success : function(data) {
            	console.log(data);
            	loadBase();
                loadItem();
				console.log("data=" + data);
            },
            error : function() {
            	$("#addBase-form span[name=info-span]").text("ajax request error");
            	console.log("ajax request error");
            }
        });//end ajax
    }
    function deleteItem(item){
        console.log(item);
        $.ajax({
            url : "/SBMS/item/"+item.iid,
            type : "delete",
            data :null,  
            dataType : "json",
            success : function(data) {
            	console.log(data);
                loadBase();
            	loadItem();
				console.log("data=" + data);
            },
            error : function() {
            	$("#addBase-form span[name=info-span]").text("ajax request error");
            	console.log("ajax request error");
            }
        });//end ajax
    }
    
    
    
    function loadItem(){
        $("#item-table").empty();
        $.ajax({
            url : "/SBMS/item/list",
            type : "get",
            data : null,  
            dataType : "json",
            success : function(data) {
            	console.log(data);
            	
                data.forEach((item,index)=>{
                    	let btn =document.createElement("input");
                    	btn.type="button";
                    	btn.value="DELETE";
                    	$(btn).on("click",(event)=>{deleteItem(item);});
                    	
                        $("#item-table")
                        .append("<tr>")
                        .append($("<td>").text(item.iid))
                        .append($("<td>").text(item.itemName))
                        .append($("<td>").text(item.num))
                        .append(btn)
                        .append("</tr>");
                        
                        
                });
				
            },
            error : function() {
            	
            	console.log("ajax request error");
            }
        });//end ajax
    }
    
    loadItem();
});
</script>
</html>