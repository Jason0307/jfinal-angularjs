package org.zhubao.generate.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zhubao.model.BaseModel;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.ICallback;

@TableBind(tableName = "z_leaderboard", pkName = "baseId")
public class Leaderboard extends BaseModel<Leaderboard>{
    private static final long serialVersionUID = 1L;
    public static Leaderboard dao = new Leaderboard();
    private Long baseId;
    private Integer gameId;
    private Integer userId;
    private Integer score;
    private Integer rank;

    public void setBaseId(Long baseId){
	    this.baseId = baseId;
    }

    public Long getBaseId(){
        return baseId;
    }

    public void setGameId(Integer gameId){
	    this.gameId = gameId;
    }

    public Integer getGameId(){
        return gameId;
    }

    public void setUserId(Integer userId){
	    this.userId = userId;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setScore(Integer score){
	    this.score = score;
    }

    public Integer getScore(){
        return score;
    }

    public void setRank(Integer rank){
	    this.rank = rank;
    }

    public Integer getRank(){
        return rank;
    }

    @Override
	public List<String> showAttrs() {
	    List<String> showAttrs = new ArrayList<String>();
		showAttrs.add("baseId");
		showAttrs.add("gameId");
		showAttrs.add("userId");
		showAttrs.add("score");
		showAttrs.add("rank");
		return showAttrs;
	}

	/**
	 * 
	 */
	public void updateLeaderboard() {
		
		Db.execute(new ICallback() {
			@Override
			public Object run(Connection conn) throws SQLException {
				String sql = "INSERT z_leaderboard(score,userId,gameId,rank) SELECT score ,userId,gameId,@rownum:=@rownum+1 as rank FROM (SELECT MAX(score) as score,userId,gameId,@rownum:=0 FROM z_gamerecord GROUP BY userId ORDER BY score DESC)t";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.execute();
				return null;
			}
		});
		
	}

	/**
	 * 
	 */
	public void clearLeaderboard() {
		Db.execute(new ICallback() {
			@Override
			public Object run(Connection conn) throws SQLException {
				String sql = "TRUNCATE z_leaderboard";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.execute();
				return null;
			}
		});
	}
}