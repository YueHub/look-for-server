/*=============================================删除已有表=============================================*/
DROP TABLE IF EXISTS post_uncover ;
DROP TABLE IF EXISTS post_view;
DROP TABLE IF EXISTS post_release;
DROP TABLE IF EXISTS user;
/*=============================================删除已有表=============================================*/

/*=============================================创建表=============================================*/
/*=========用户表=========*/
CREATE TABLE user (
	identify_id VARCHAR(32) PRIMARY KEY, -- 用户唯一标识 ID
	self_introduction VARCHAR(100), -- 用户自我介绍
	phone VARCHAR(20), -- 用户手机号
	email VARCHAR(30), -- 用户电子邮箱
	popularity_value VARCHAR(8), -- 用户人气值
	credit_value VARCHAR(8), -- 用户信用值
	credit_time TIMESTAMP NOT NULL -- 用户创建时间
);

/*=========招聘帖子表=========*/
CREATE TABLE post_release (
	identify_id VARCHAR(32) PRIMARY KEY, -- 帖子唯一标识 ID
	release_user VARCHAR(10) NOT NULL, -- 发帖人 
	release_time TIMESTAMP NOT NULL, -- 发布时间
	title VARCHAR(50) NOT NULL, -- 帖子标题
	content VARCHAR(200), -- 帖子内容
	description VARCHAR(500), -- 需求描述 
	reward VARCHAR(10) NOT NULL, -- 奖金
	phone VARCHAR(20) NOT NULL, -- 联系手机号
	email VARCHAR(30), -- 联系电子邮件
	self_introduce VARCHAR(200), -- 自我介绍
	extra_info VARCHAR(100), -- 额外信息
	post_img_urls VARCHAR(200), -- 帖子图像	
	view_count BIGINT DEFAULT 0, -- 被浏览数量
	uncover_count BIGINT DEFAULT 0, -- 被揭榜数量
	success_count BIGINT DEFAULT 0, -- 被中标数量
	paid_reward VARCHAR(10) DEFAULT 0, -- 已经分发的奖金
	status INT DEFAULT 1, -- 帖子状态 0 表示已经结束 1表示正在进行 2表示揭榜被暂停 
	FOREIGN KEY(release_user) REFERENCES user(identify_id) ON DELETE CASCADE
);

/*=========帖子揭榜表=========*/
CREATE TABLE post_uncover (
	identify_id VARCHAR(32) PRIMARY KEY, -- 帖子揭榜唯一标识 ID
	uncover_user VARCHAR(10) NOT NULL, -- 揭榜人 
	uncover_post VARCHAR(10) NOT NULL, -- 揭榜帖子 
	uncover_time TIMESTAMP NOT NULL, -- 揭榜时间
	uncover_reason VARCHAR(100), -- 揭榜理由
	FOREIGN KEY(uncover_user) REFERENCES user(identify_id) ON DELETE CASCADE,
	FOREIGN KEY(uncover_post) REFERENCES post_release(identify_id) ON DELETE CASCADE
);

/*=========帖子浏览表=========*/
CREATE TABLE post_view (
	identify_id VARCHAR(32) PRIMARY KEY, -- 帖子浏览唯一标识 ID
	view_user VARCHAR(10) NOT NULL, -- 浏览人 
	view_post VARCHAR(10) NOT NULL, -- 浏览帖子 
	view_time TIMESTAMP NOT NULL, -- 浏览时间
	FOREIGN KEY(view_user) REFERENCES user(identify_id) ON DELETE CASCADE,
	FOREIGN KEY(view_post) REFERENCES post_release(identify_id) ON DELETE CASCADE
);
/*=============================================创建表=============================================*/

/*=============================================插入测试数据=============================================*/
INSERT INTO user VALUES('1', '测试用户1', '', '', '200', '200', '2017.11.01');
INSERT INTO user VALUES('2', '测试用户2', '', '', '500', '300', '2017.11.01');
INSERT INTO user VALUES('3', '测试用户3', '', '', '200', '100', '2017.11.01');
INSERT INTO user VALUES('4', '测试用户4', '', '', '100', '200', '2017.11.01');
INSERT INTO user VALUES('5', '测试用户5', '', '', '50', '50', '2017.11.01');
	
	
INSERT INTO post_release VALUES('60e36343c17943e6af9c15243fc5972a', '1', '2017-11-07 20:57:03', '20718-UI视觉设计师（深圳） [深圳·南山区]', '主要负责网上商城的UI界面设计，和产品经理、交互设计师一起完成产品的方案设计与输出，并参与相应产品的运营和品牌延伸设计。','从事设计工作3年以上，具有移动端UI设计经验，具备PC端更佳；<br>有不错的视觉设计能力和审美洞察，保持好奇心；<br>善于沟通和思考，对于极致体验和美学有追求；<br>富有激情，关注细节，具有匠心，突破自己，具备良好合作态度及团队精神；<br>能够承受高强度的工作压力，有制作动画demo经验及手绘原创能力较强者优先考虑。<br>', '10000', '1324124xxxx', 'xxx@126.com', '', '深圳 - 南山区 - 大族科技', '2017/10/7/fe099771c039bbfd6c6299fdafddaf3a.jpg', 0, 0, 0, '0', 1);
INSERT INTO post_release VALUES('60e36343c17943e6af9c15243fc5972b', '1', '2017-11-07 20:57:04', 'GO语言服务器端开发工程师', '1.完成基于go/redis/mysql等技术的服务器端API开发，使之能支撑十万用户级的企业应用。<br>2.负责项目的设计、编码、调优、测试及Bug处理；<br>3.负责产品服务端开发，不断进行产品演进，提高产品质量和用户体验；<br>4.根据产品需求，写出良好的解决方案。<br>','1.本科及以上学历，计算机相关专业，两年以上服务端研发经验；<br>2.深入理解计算机原理，有扎实的数据结构和算法基础；<br>3.深入理解linux系统及其原理，了解windows服务器，熟悉TCP/IP、HTTP协议以及网络编程；<br>4.良好的编码和文档习惯，对代码美感的追求孜孜不倦；<br>5.精通Go语言，熟悉C/C++/Python优先；<br>6.熟悉常用的sql、nosql数据库原理，阅读和理解优秀的开源系统代码；<br>7.具有分布式系统设计和开发经验者优先<br>', '10000', '1324124xxxx', 'xxx@126.com', '', '深圳 - 南山区 - 大族科技', '2017/10/7/fe099771c039bbfd6c6299fdafddaf3b.jpg', 0, 0, 0, '0', 1);
INSERT INTO post_release VALUES('60e36343c17943e6af9c15243fc5972c', '2', '2017-11-07 20:57:05', 'MIG06-应用宝高级内容主编（深圳） [深圳·南山区]', '1.完成基于go/redis/mysql等技术的服务器端API开发，使之能支撑十万用户级的企业应用。<br>2.负责项目的设计、编码、调优、测试及Bug处理；<br>3.负责产品服务端开发，不断进行产品演进，提高产品质量和用户体验；<br>','1.本科及以上学历，计算机相关专业，两年以上服务端研发经验；<br>2.深入理解计算机原理，有扎实的数据结构和算法基础；<br>', '10000', '1324124xxxx', 'xxx@126.com', '', '深圳 - 南山区 - 大族科技', '2017/10/7/fe099771c039bbfd6c6299fdafddaf3c.jpg', 0, 0, 0, '0', 1);
INSERT INTO post_release VALUES('60e36343c17943e6af9c15243fc5972d', '1', '2017-11-07 20:57:06', '19116-互联网+nodejs应用', '负责医疗项目的web系统的开发；<br>2.负责医疗项目需求分析、系统架构及优化工作。<br>','本科及以上学历，至少5年以上web开发工作经验，有微信公众号开发经验者优先；<br>精通Node.js、熟悉express、koa等web开发框架；<br>精通MySQL数据库，熟悉memoryCache、redis、MongoDB；<br>精通HTML、JavaScript、Ajax、CSS等前端开发技术；<br>能熟练使用主流的JavaScript框架（SeaJS、BackboneJS、GruntJS、Gulp等），并精通其中的一种以上；<br>对Web标准和兼容性有良好认识，具备良好的代码风格以及接口、架构设计能力；<br>熟悉HTTP的基本工作原理以及常用Web开发调试工具；<br>', '10000', '1324124xxxx', 'xxx@126.com', '', '深圳 - 南山区 - 大族科技', '2017/10/7/fe099771c039bbfd6c6299fdafddaf3d.jpg', 0, 0, 0, '0', 1);
/*=============================================插入测试数据=============================================*/