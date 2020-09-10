function Delete(url)
{
	if(confirm("确定删除吗")){
		location.href = url;
	}
}

function FocusItem(obj)
{
	obj.parentNode.parentNode.className = "current";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}

function CheckItem(obj)
{
	//obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	switch(obj.name) {
		case "title":
			if(obj.value == "") {
				msgBox.innerHTML = "标题不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "content":
			if(obj.value == "") {
				msgBox.innerHTML = "内容不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "replyContent":
			if(obj.value == "") {
				msgBox.innerHTML = "回复内容不能为空";
				msgBox.className = "error";
				return false;
			} else if(obj.value != document.getElementById("passWord").value) {
				msgBox.innerHTML = "两次输入的密码不相同";
				msgBox.className = "error";
				return false;
			}
			break;
		case "productName":
			if(obj.value == "") {
				msgBox.innerHTML = "商品名称不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "productPrice":
			if(obj.value == "") {
				msgBox.innerHTML = "商品价格不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "productStock":
			if(obj.value == "") {
				msgBox.innerHTML = "商品库存不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "className":
			if(obj.value == "") {
				msgBox.innerHTML = "分类名不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "userName":
			if(obj.value == "") {
				msgBox.innerHTML = "用户名不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "realName":
			if(obj.value == "") {
				msgBox.innerHTML = "姓名不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "passWord":
			if(obj.value == "") {
				msgBox.innerHTML = "密码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "address":
			if(obj.value == "") {
				msgBox.innerHTML = "地址不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
	}
	return true;
}

function checkForm(frm)
{
	var els = frm.elements;
	for(var i=0; i<els.length; i++) {
		if(!CheckItem(els[i])) return false;		
	}
	return true;
}