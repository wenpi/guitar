package com.xukaiqiang.guitar.orm.entity;

import com.xukaiqiang.guitar.orm.dialect.AbstractUser_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-06-28T00:57:41.884+0800")
@StaticMetamodel(User.class)
public class User_ extends AbstractUser_ {
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, String> passWord;
	public static volatile SingularAttribute<User, Integer> roleId;
	public static volatile SingularAttribute<User, Integer> detailId;
	public static volatile SingularAttribute<User, String> sex;
	public static volatile SingularAttribute<User, Integer> age;
	public static volatile SingularAttribute<User, String> nickName;
}
