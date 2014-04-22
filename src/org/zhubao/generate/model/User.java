package org.zhubao.generate.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.zhubao.model.BaseModel;
import org.zhubao.vo.PieVo;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Record;

@TableBind(tableName = "z_user", pkName = "userId")
public class User extends BaseModel<User>{
	private static final long serialVersionUID = 1L;
	public static User dao = new User();
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private Date birth;
    private String icon;
    public void setUserId(Integer userId){
	    this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }
    public void setUsername(String username){
	    this.username = username;
    }

    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
	    this.password = password;
    }

    public String getPassword(){
        return password;
    }
    public void setEmail(String email){
	    this.email = email;
    }

    public String getEmail(){
        return email;
    }
    public void setBirth(Date birth){
	    this.birth = birth;
    }

    public Date getBirth(){
        return birth;
    }
    public void setIcon(String icon){
	    this.icon = icon;
    }

    public String getIcon(){
        return icon;
    }

     @Override
	public List<String> showAttrs() {
	    List<String> showAttrs = new ArrayList<String>();
		showAttrs.add("userId");
		showAttrs.add("username");
		showAttrs.add("password");
		showAttrs.add("email");
		showAttrs.add("birth");
		showAttrs.add("icon");
		return showAttrs;
	}

	/**
	 * @return
	 */
	public String getPieData() {
		
		List<Record> users = User.dao.findByList();
		JSONArray jsonArray = new JSONArray();
		if(!users.isEmpty()){
			for(Record record : users){
				PieVo vo = new PieVo();
				vo.setName(record.get("username").toString());
				vo.setY((int)record.get("userId"));
				JSONObject jsonObject = JSONObject.fromObject(vo);
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray.toString();
	}

}