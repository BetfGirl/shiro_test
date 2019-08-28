package controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.pic_T;

@Controller
public class testController {
	
	
	@RequestMapping("sss")
	public  @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req )throws Exception {
		String oname=file.getOriginalFilename();
		String ex=oname.substring(oname.lastIndexOf("."),oname.length());
		String nname = UUID.randomUUID()+ex;
  
		String path=req.getSession().getServletContext().getRealPath("/");
		path=new File(path).getParentFile().getPath()+"/upload";
		System.out.println(path);
		file.transferTo(new File(path,nname));
		System.out.println("/upload/"+nname);
		return "/upload/"+nname;
	}
	
//	@RequestMapping("login1")
//	@RequiresPermissions("user")
//	public void login(String name,String pass) {
//		Subject sub = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(name,pass);
//		System.out.println("��ʼ��½");
//		 sub.login(token);    
//	}
	
	@RequestMapping("aa")
	public void index() {
		System.out.println("afdaf");
	}
}
