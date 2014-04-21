package org.zhubao.generate.model;

import java.util.ArrayList;
import java.util.List;

import org.zhubao.model.BaseModel;

import com.jfinal.ext.plugin.tablebind.TableBind;

@TableBind(tableName = "z_gamerecord", pkName = "recordId")
public class GameRecord extends BaseModel<GameRecord> {
	private static final long serialVersionUID = 1L;
	private Long recordId;
	private Integer gameId;
	private Integer score;

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getScore() {
		return score;
	}

	@Override
	public List<String> showAttrs() {
		List<String> showAttrs = new ArrayList<String>();
		showAttrs.add("recordId");
		showAttrs.add("gameId");
		showAttrs.add("score");
		return showAttrs;
	}
}