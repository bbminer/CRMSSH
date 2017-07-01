var navs = [{
	"title": "客户管理",
	"icon": "fa-cubes",
	"spread": false,
	"children": [{
		"title": "新增客户",
		"icon": "&#xe63c;",
		"href": "toAddPage"
	}, {
		"title": "客户列表",
		"icon": "&#xe63c;",
		"href": "list"
	}, {
		"title": "分页客户列表",
		"icon": "&#xe63c;",
		"href": "limitPage?pageBean.currentPage=1"
	}]
}, {
	"title": "联系人管理",
	"icon": "fa-cubes",
	"spread": false,
	"children": [{
		"title": "新增联系人",
		"icon": "&#xe63c;",
		"href": "toLinkmanAddPage"
	}, {
		"title": "联系人列表",
		"icon": "&#xe63c;",
		"href": "listLinkman"
	}]
}, {
	"title": "客户拜访管理",
	"icon": "fa-cubes",
	"spread": false,
	"children": [{
		"title": "新增客户拜访记录",
		"icon": "&#xe63c;",
		"href": "visitToAddPage"
	},{
		"title": "拜访记录列表",
		"icon": "&#xe63c;",
		"href": "visitList"
	}]
}, {
	"title": "综合查询",
	"icon": "fa-cubes",
	"spread": false,
	"children": [{
		"title": "客户信息查询",
		"icon": "&#xe63c;",
		"href": "customerToSelectPage"
	}, {
		"title": "联系人信息查询",
		"icon": "&#xe63c;",
		"href": "linkmanToSelectPage"
	}, {
		"title": "拜访记录信息查询",
		"icon": "&#xe63c;",
		"href": "visitToSelectPage"
	}]
},{
	"title": "统计查询",
	"icon": "fa-cubes",
	"spread": false,
	"children": [{
		"title": "客户来源统计",
		"icon": "&#xe63c;",
		"href": "customerSourceCount"
	}, {
		"title": "客户级别统计",
		"icon": "&#xe63c;",
		"href": "customerLevelCount"
	}]
},
{
	"title": "系统管理",
	"icon": "fa-cubes",
	"href": "systemManager.html",
	"spread": false
}];