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
            baseName:<input type="text" name="baseName" /><br>
            <input type="button" name="submit" value="add" id="addBase-btn" /><br><br><span name="info-span"></span>
        </form>
        <h3>add item</h3>
        <table border="1">
            <tbody id="item-table"></tbody>
        </table>
        <form id="addItem-form">
            itemName:<input type="text" name="itemName" /><br> num:
            <input type="text" name="num" /><br> bid:
            <input type="text" name="bid" /><br>
            <input type="button" name="submit" value="add" id="addItem-btn" /><br><br><span name="info-span"></span>
        </form>
    </body>
    <script>
        $(document).ready(function() {
            function myAjax(url, method, data, callback) {
                let options = {
                    "url": url,
                    "type": method,
                    "data": data
                }
                $.ajax(options).done(function(obj) {
                    callback(obj);
                });
            }

            function form2json(form) {
                console.log("form2json");
                let obj = {};
                $.each(form.children("[type!=submit]"), function(index, item) {
                    let $item = $(item);
                    obj[$item.attr("name")] = $item.val();
                });

                //                form.children("[type!=submit]").each(function(index,item){
                //                    obj[item.attr("name")]=item.val(); 
                //                });
                return obj;
            }

            function BookComponent($view, url) {
                let model = null;
                let tbody = $view.find("tbody");
                renderTable = renderTable.bind(this);
                bindAddForm = bindAddForm.bind(this); //this=BookComponent
                bindEvent = bindEvent.bind(this);
                //local function
                function renderTable() {
                    //model needed
                    tbody.empty();
                    model.forEach((item, index) => {
                        let btn = document.createElement("input");
                        btn.type = "button";
                        btn.value = "DELETE";
                        $(btn).on("click", (event) => {
                            this.delete(item);
                        });
                        $("<tr>")
                            .append($("<td>").text(item.bookId)).on("dblclick", (event) => {
                                //alert("fdfd")
                                this.initUpdateForm(item);
                            })
                            .append($("<td>").text(item.bookName))
                            .append($("<td>").text(item.bookAuthor))
                            .append(btn)
                            .appendTo(tbody);

                    });
                }


                function bindEvent() {
                    $("#addForm").on("submit", event => {
                        event.preventDefault();
                        let data = form2json($(event.target));
                        myAjax(url, "POST", data, dt => {
                            //  data.id= parseInt(Math.random()*10000);
                            console.log("bindEvent():" + data);
                            //need to find bookComponent
                            this.add(dt);
                        });
                    });
                }



                function bindAddForm() {
                    $("#addForm").on("submit", event => {
                        event.preventDefault();
                        let data = form2json($(event.target));
                        myAjax(url, "POST", data, dt => {
                            //  data.id= parseInt(Math.random()*10000);
                            console.log("bindAddForm():" + data);
                            //need to find bookComponent
                            this.add(dt);
                        });
                    });
                }

                function bindUpdateForm() {
                    $("#updateForm").on("submit", even => {
                        even.preventDefault();
                        //alert("bindUpdateForm()");
                        let data = form2json($(event.target));
                        console.log(data.bookId);
                        myAjax(url + data.bookId, "PUT", data, dt => {
                            //  data.id= parseInt(Math.random()*10000);
                            console.log("bindUpdateForm():" + data);
                            //need to find bookComponent
                            model.push(dt);
                            //this.render();
                            renderTable();
                        });
                    });
                }


                this.init = function() {
                    //require the model 
                    //render
                    bindAddForm();
                    bindUpdateForm();
                    myAjax(url, "GET", null, (data) => {
                        model = data;
                        //console.log(data);
                        this.render();
                    });
                }

                this.render = function() {
                    renderTable();
                }

                this.add = function(book) {
                    //add a Customer to render;
                    model.push(book);
                    this.render();
                }

                this.delete = function(book) {
                    // model.pop();
                    this.render();
                    myAjax(url + book.bookId, "DELETE", null, dt => {
                        //remove the book from the model
                        let index = model.indexOf(book);
                        model.splice(index, 1);
                        this.render();
                    });
                }

                this.initUpdateForm = function(item) {
                    //console.log(item);
                    console.log(item.bookId + "," + item.bookName + "," + item.bookAuthor + "," + item.bookDate);
                    $("#updateForm>form>input[name=bookId]").val(item.bookId);
                    $("#updateForm>form>input[name=bookName]").val(item.bookName);
                    $("#updateForm>form>input[name=bookAuthor]").val(item.bookAuthor);
                    model.pop(item);
                    this.render();
                }

                this.update = function(book) {
                    model.push(book);
                    this.render();
                }

            } // end function BookComponent

            //  })();
            let bookComponent = new BookComponent($("#app"), "http://localhost:9090/SpringMVC/books/").init();
        });

    </script>

    </html>
