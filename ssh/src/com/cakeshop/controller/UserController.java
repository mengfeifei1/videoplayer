package com.cakeshop.controller;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cakeshop.bean.UserBean;
import com.cakeshop.service.UserService;

import net.sf.json.JSONObject;

 
@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	@Resource
	private UserService userService;
	@RequestMapping("/person")
	public void findUserInfo(int userId,HttpServletRequest req,HttpServletResponse rep) throws IOException {
		UserBean userbean=userService.findPerson(userId);
		System.out.print(userbean.getUserAddress());
		return;
	}
	/**
	 * 根据手机号判断用户是否存在
	 */
	@RequestMapping("login")
	public void login(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		System.out.println("123");
		InputStream is=req.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String json=br.readLine();
		System.out.println("数据"+json);
		JSONObject object = JSONObject.fromObject(json);
		String userPhone = object.getString("userTelephone");
		String usernewPassword = object.getString("userPassword");
		System.out.println("userPhone:"+userPhone+"  userPassword:"+usernewPassword);
		boolean isExist = userService.isExistUser(userPhone);
		System.out.println("isExist----"+isExist);
		JSONObject object1 = new JSONObject();
		if(isExist == true) {
			System.out.print("执行");
			//用户存在
			UserBean user = userService.findUserByUserPhone(userPhone);
			System.out.print(user.getUserIntro());
			user.setUserTelephone(userPhone);
			user.setUserPassword(usernewPassword);
			System.out.print(user.getUserPassword());
			userService.changeUserPswd(user);
			object1.put("user", user);
			System.out.println(user);
			resp.getWriter().append(object1.toString());
		}
	}
	/**
	 * 根据手机、密码判断用户是否存在
	 */
	//,method=RequestMethod.POST
	@RequestMapping(value="login2")
	public void login2(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		InputStream is=req.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		String json=br.readLine();
		System.out.println("数据"+json);
		JSONObject object = JSONObject.fromObject(json);
		String userPhone = object.getString("userTelephone");
		String userPassword = object.getString("userPassword");
		System.out.println("userPhone:"+userPhone+"  userPassword:"+userPassword);
		
		boolean isExist = userService.isExistUser(userPhone);
		System.out.println("isExist----"+isExist);
		JSONObject back = new JSONObject();
		Map<String,Object> map = new HashMap<>();
		if(isExist == true) {
			//用户存在
			UserBean user = userService.findUserByUserTel(userPhone);
			int userId = user.getUserId();
			String userPassword2 = user.getUserPassword();
			System.out.println("userPassword="+userPassword+";userPassword2="+userPassword2);
			if(userPassword.equals(userPassword2)) {
				List<Integer> typeList = new ArrayList<>();
//				List<Title> titleList = titleService.findType(userId);
//				for(int i=0;i<titleList.size();i++) {
//					typeList.add(titleList.get(i).getType().getTypeId());
//				}
				typeList.add(1);
				String msg = "该用户存在";
				map.put("typeList", typeList);
				map.put("user", user);
				map.put("msg", msg);
				back.put("map", map);
				System.out.println("back---"+back.toString());
				resp.getWriter().append(back.toString());
			}else {
				String msg = "密码输入错误";
				map.put("typeList", null);
				map.put("user", null);
				map.put("msg", msg);
				back.put("map", map);
				System.out.println("back---"+back.toString());
				resp.getWriter().append(back.toString());
			}
		}else {
			//用户不存在
			String msg = "该用户不存在";
			map.put("typeList", null);
			map.put("user", null);
			map.put("msg", msg);
			back.put("map", map);
			System.out.println("back---"+back.toString());
			resp.getWriter().append(back.toString());
		}
	}

	@RequestMapping("register")
	public void register(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("register---"+json);
		JSONObject object = JSONObject.fromObject(json);
		System.out.println("json");
		String userName = object.getString("userName");
		String userPassword = object.getString("userPassword");
		String userPhone = object.getString("userTelephone");

//		String userName = "kk";
//		String userPassword = "123456789a";
//		String userPhone = "13131163001";
		String userPhoto = "images/userPhoto/2.png";
		String userIntro = "添加个人描述，可以让大家更好的认识你";
		String userAddress = "完善你的位置信息";
		System.out.println("头像：" + userPhoto + "; 用户名：" + userName + "; 密码：" + userPassword + "; 电话：" + userPhone);
		UserBean user = new UserBean();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserTelephone(userPhone);
		user.setUserAddress(userAddress);
		user.setUserIntro(userIntro);
		user.setUserPhoto(userPhoto);
		user.setUserSex("未知");
		boolean isRegist = userService.isExistUser(userPhone);
		if(isRegist == true) {
			//该用户已经注册过
			resp.getWriter().append("该用户已经注册");
		}else {
			//该用户是新用户
			int count = userService.insertUser(user);
			System.out.println("插入了"+count+"行");
			if(count != 0) {
				resp.getWriter().append("注册成功");
			}else {
				resp.getWriter().append("注册失败");
			}
		}
		System.out.print("register");
		}
	@RequestMapping("updateUser")
	public void changeInfo(HttpServletResponse resp,HttpServletRequest req) throws IOException {
		InputStream is = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String json = br.readLine();
		System.out.println("register---"+json);
		JSONObject object = JSONObject.fromObject(json);
		System.out.println("json");
		String userName = object.getString("userName");
		String userSex=object.getString("userSex");
		String userIntro=object.getString("userIntro");
		String userBirth=object.getString("userBirth");
		String userAddress=object.getString("userAddress");
		int userId=object.getInt("userId");
		UserBean user=new UserBean();
		user.setUserName(userName);
		user.setUserAddress(userAddress);
		user.setUserSex(userSex);
		user.setUserIntro(userIntro);
		user.setUserBirth(userBirth);
		user.setUserId(userId);
		System.out.println(user.toString());
		userService.updateUser(user);
		System.out.print("更新成功");
	}

	/**
	 * 修改头像
	 * @param userId
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("updatePhoto")
	public void updatePhoto(int userId,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		System.out.println("updatePhoto");
		//1、创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录。 
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    //2、使用DiskFileItemFactory 对象创建ServletFileUpload对象，并设置上传文件的大小限制。
	    ServletFileUpload upload = new ServletFileUpload(factory);
		String userPhoto = "";   
	    try{  
	    	//3、调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
	    	List<FileItem>list = upload.parseRequest(req);
			for(FileItem item:list) {
				if(item.isFormField()) {
					//4.1、 为普通表单字段，则调用getFieldName、getString方法得到字段名和字段值。
				}else{  
					//4.2、为上传文件，则调用getInputStream方法得到数据输入流，从而读取上传数据。
					//pathName有的浏览器会返回文件名，而有的浏览器会返回“路径”+“文件名”
					String pathName = item.getName(); 
					//fileName获取的是文件的名字
					String fileName = pathName.substring(pathName.lastIndexOf("\\")+1);
					System.out.print(fileName);
					//serverPath是项目运行后的路径,在使用ServletContext.getRealPath() 时，传入的参数是从 当前servlet 部署在tomcat中的文件夹算起的相对路径，要以"/" 开头，否则会找不到路径，导致NullPointerException
					String serverPath = req.getSession().getServletContext().getRealPath("/");
					fileName = "images/userPhotos/"+ userId+"new.jpg";
					item.write(new File(serverPath+"\\images\\userPhotos\\"+fileName));
					userPhoto = fileName;
					System.out.println("userPhoto"+userPhoto);
					UserBean u = new UserBean();
					u.setUserId(userId);
					u.setUserPhoto(userPhoto);
					 userService.updateUserPhoto(u);
					System.out.println("插入成功");
				}
			}
		}catch(Exception e){
			e.printStackTrace();  
        }     
	  }

	@RequestMapping("loginById")
	public void getUserId(int userId,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		UserBean user=new UserBean();
		user=userService.findPerson(userId);
		JSONObject object1 = new JSONObject();
		object1.put("currentUser", user);
		resp.getWriter().append(object1.toString());
	}
	
	
} 

	

	

