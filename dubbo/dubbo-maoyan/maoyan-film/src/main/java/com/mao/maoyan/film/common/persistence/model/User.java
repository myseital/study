package com.mao.maoyan.film.common.persistence.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author myseital
 */
@Data
public class User extends Model<User> {

	private Long id;
	private String userName;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
