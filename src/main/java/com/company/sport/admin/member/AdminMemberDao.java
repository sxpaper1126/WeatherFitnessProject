package com.company.sport.admin.member;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.company.sport.admin.member.AdminMemberVo;
import com.company.sport.admin.api.WeatherApi;
import com.company.sport.admin.member.AdminMemberSportVo;

@Component
public class AdminMemberDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	WeatherApi weatherApi;

	public boolean isAdminMember(String a_m_id) {

		String sql = "SELECT COUNT(*) FROM tbl_admin " + "WHERE a_m_id = ?";

		int result = jdbcTemplate.queryForObject(sql, Integer.class, a_m_id);

		if (result < 0) {
			return true;
		} else {
			return false;
		}
	}

	public int insertAdminAccount(AdminMemberVo adminMemberVo) {

		List<Object> args = new ArrayList<>();

		String sql = "INSERT INTO tbl_admin(";

		if ("super admin".equals(adminMemberVo.getA_m_id())) {
			sql += "a_m_approval, ";
			args.add(1);
		}

		sql += "a_m_id, ";
		args.add(adminMemberVo.getA_m_id());

		sql += "a_m_pw, ";
		args.add(passwordEncoder.encode(adminMemberVo.getA_m_pw()));

		sql += "a_m_name, ";
		args.add(adminMemberVo.getA_m_name());

		sql += "a_m_gender, ";
		args.add(adminMemberVo.getA_m_gender());

		sql += "a_m_part, ";
		args.add(adminMemberVo.getA_m_part());

		sql += "a_m_position, ";
		args.add(adminMemberVo.getA_m_position());

		sql += "a_m_mail, ";
		args.add(adminMemberVo.getA_m_mail());

		sql += "a_m_phone, ";
		args.add(adminMemberVo.getA_m_phone());

		sql += "a_m_reg_date, a_m_mod_date, a_m_age) ";
		args.add(adminMemberVo.getA_m_age());

		if ("super admin".equals(adminMemberVo.getA_m_id())) {
			sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW(), ?)";
		} else {
			sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW(), ?)";
		}

		int result = -1;

		try {
			result = jdbcTemplate.update(sql, args.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public AdminMemberVo selectAdmin(AdminMemberVo adminMemberVo) {

		String sql = "SELECT * FROM tbl_admin WHERE a_m_id = ? AND a_m_approval > 0";

		List<AdminMemberVo> adminMemberVos = new ArrayList<AdminMemberVo>();

		try {
			adminMemberVos = jdbcTemplate.query(sql, new RowMapper<AdminMemberVo>() {
				@Override
				public AdminMemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					AdminMemberVo adminMemberVo = new AdminMemberVo();
					adminMemberVo.setA_m_no(rs.getInt("a_m_no"));
					adminMemberVo.setA_m_approval(rs.getInt("a_m_approval"));
					adminMemberVo.setA_m_id(rs.getString("a_m_id"));
					adminMemberVo.setA_m_pw(rs.getString("a_m_pw"));
					adminMemberVo.setA_m_name(rs.getString("a_m_name"));
					adminMemberVo.setA_m_gender(rs.getString("a_m_gender"));
					adminMemberVo.setA_m_part(rs.getString("a_m_part"));
					adminMemberVo.setA_m_position(rs.getString("a_m_position"));
					adminMemberVo.setA_m_mail(rs.getString("a_m_mail"));
					adminMemberVo.setA_m_phone(rs.getString("a_m_phone"));
					adminMemberVo.setA_m_reg_date(rs.getString("a_m_reg_date"));
					adminMemberVo.setA_m_mod_date(rs.getString("a_m_mod_date"));
					adminMemberVo.setA_m_age(rs.getInt("a_m_age"));
					return adminMemberVo;
				}
			}, adminMemberVo.getA_m_id());
			if (!passwordEncoder.matches(adminMemberVo.getA_m_pw(), adminMemberVos.get(0).getA_m_pw()))
				adminMemberVos.clear();
		} catch (Exception e) {

			e.printStackTrace();

		}

		return adminMemberVos.size() > 0 ? adminMemberVos.get(0) : null;
	}

	public List<AdminMemberVo> selectAdmins() {

		String sql = "SELECT * FROM tbl_admin";

		List<AdminMemberVo> adminMemberVos = new ArrayList<AdminMemberVo>();

		try {
			adminMemberVos = jdbcTemplate.query(sql, new RowMapper<AdminMemberVo>() {
				@Override
				public AdminMemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					AdminMemberVo adminMemberVo = new AdminMemberVo();
					adminMemberVo.setA_m_no(rs.getInt("a_m_no"));
					adminMemberVo.setA_m_approval(rs.getInt("a_m_approval"));
					adminMemberVo.setA_m_id(rs.getString("a_m_id"));
					adminMemberVo.setA_m_pw(rs.getString("a_m_pw"));
					adminMemberVo.setA_m_name(rs.getString("a_m_name"));
					adminMemberVo.setA_m_gender(rs.getString("a_m_gender"));
					adminMemberVo.setA_m_part(rs.getString("a_m_part"));
					adminMemberVo.setA_m_position(rs.getString("a_m_position"));
					adminMemberVo.setA_m_mail(rs.getString("a_m_mail"));
					adminMemberVo.setA_m_phone(rs.getString("a_m_phone"));
					adminMemberVo.setA_m_reg_date(rs.getString("a_m_reg_date"));
					adminMemberVo.setA_m_mod_date(rs.getString("a_m_mod_date"));
					adminMemberVo.setA_m_age(rs.getInt("a_m_age"));
					return adminMemberVo;
				}
			});
		} catch (Exception e) {

			e.printStackTrace();

		}
		return adminMemberVos;
	}

	public int updateAdminAccount(int a_m_no) {

		String sql = "UPDATE tbl_admin SET " + "a_m_approval = 1 " + "WHERE a_m_no = ?";

		int result = -1;

		try {

			result = jdbcTemplate.update(sql, a_m_no);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return result;

	}

	public int updateAdminAccount(AdminMemberVo adminMemberVo) {

		String sql = "UPDATE tbl_admin SET " + "a_m_name = ?, " + "a_m_gender = ?, " + "a_m_part = ?, "
				+ "a_m_position = ?, " + "a_m_mail = ?, " + "a_m_phone = ?, " + "a_m_mod_date = NOW() "
				+ "WHERE a_m_no = ?";

		int result = -1;

		try {

			result = jdbcTemplate.update(sql, adminMemberVo.getA_m_name(), adminMemberVo.getA_m_gender(),
					adminMemberVo.getA_m_part(), adminMemberVo.getA_m_position(), adminMemberVo.getA_m_mail(),
					adminMemberVo.getA_m_phone(), adminMemberVo.getA_m_no(), adminMemberVo.getA_m_age());

		} catch (Exception e) {
			e.printStackTrace();

		}

		return result;

	}

	public AdminMemberVo selectAdmin(int a_m_no) {

		String sql = "SELECT * FROM tbl_admin " + "WHERE a_m_no = ?";

		List<AdminMemberVo> adminMemberVos = new ArrayList<AdminMemberVo>();

		try {

			adminMemberVos = jdbcTemplate.query(sql, new RowMapper<AdminMemberVo>() {

				@Override
				public AdminMemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {

					AdminMemberVo adminMemberVo = new AdminMemberVo();

					adminMemberVo.setA_m_no(rs.getInt("a_m_no"));
					adminMemberVo.setA_m_id(rs.getString("a_m_id"));
					adminMemberVo.setA_m_pw(rs.getString("a_m_pw"));
					adminMemberVo.setA_m_name(rs.getString("a_m_name"));
					adminMemberVo.setA_m_gender(rs.getString("a_m_gender"));
					adminMemberVo.setA_m_part(rs.getString("a_m_part"));
					adminMemberVo.setA_m_position(rs.getString("a_m_position"));
					adminMemberVo.setA_m_mail(rs.getString("a_m_mail"));
					adminMemberVo.setA_m_phone(rs.getString("a_m_phone"));
					adminMemberVo.setA_m_reg_date(rs.getString("a_m_reg_date"));
					adminMemberVo.setA_m_mod_date(rs.getString("a_m_mod_date"));
					adminMemberVo.setA_m_age(rs.getInt("a_m_age"));

					return adminMemberVo;

				}

			}, a_m_no);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return adminMemberVos.size() > 0 ? adminMemberVos.get(0) : null;

	}

	public List<String> getRecommendedSports(AdminMemberSportVo adminMemberSportVo, Model model) {
		try {

			String weatherInfo = weatherApi.getWeather(55, 125);
			StringBuilder sqlBuilder = new StringBuilder("SELECT sport_name FROM rec_sport WHERE 1 = 1");
			processWeatherInfo(model, "location", weatherInfo);

			String windSpeed = (String) model.getAttribute("location_WindSpeed");
			String temperature = (String) model.getAttribute("location_Temperature");
			String rainfall1h = (String) model.getAttribute("location_Rainfall1h");

			if (!rainfall1h.isEmpty() && Double.parseDouble(rainfall1h) > 0) {
				if (!temperature.isEmpty() && Double.parseDouble(temperature) >= 20) {
					if (Double.parseDouble(windSpeed) >= 1.5) {

						sqlBuilder.append(" AND windSpeed >= 1.5 AND temperature >= 20 AND rainfall = 1");
					} else {

						sqlBuilder.append(" AND windSpeed <= 1.5 AND temperature < 20 AND rainfall = 1");
					}
				} else {
					if (Double.parseDouble(windSpeed) >= 1.5) {

						sqlBuilder.append(" AND windSpeed >= 1.5 AND temperature >= 20 AND rainfall = 1");
					} else {

						sqlBuilder.append(" AND windSpeed <= 1.5 AND temperature < 20 AND rainfall = 1");
					}
				}
			} else {
				if (!temperature.isEmpty() && Double.parseDouble(temperature) >= 20) {
					if (Double.parseDouble(windSpeed) >= 1.5) {

						sqlBuilder.append(" AND windSpeed >= 1.5 AND temperature >= 20 AND rainfall = 0");
					} else {

						sqlBuilder.append(" AND windSpeed <= 1.5 AND temperature >= 20 AND rainfall = 0");
					}
				} else {
					if (Double.parseDouble(windSpeed) >= 1.5) {

						sqlBuilder.append(" AND windSpeed >= 1.5 AND temperature < 20 AND rainfall = 0");
					} else {

						sqlBuilder.append(" AND windSpeed <= 1.5 AND temperature < 20 AND rainfall = 0");
					}
				}
			}

			String sql = sqlBuilder.toString();
			List<String> recommendedSports = jdbcTemplate.queryForList(sql, String.class);
			return recommendedSports;

		} catch (IOException e) {
			e.printStackTrace();
			return getRecommendedSports(null, model);
		}
	}

	private static String extractValue(String input, String dataType) {
		String obsrValueTag = "<obsrValue>";
		int startIndex = input.indexOf(dataType);
		int obsrValueStartIndex = input.indexOf(obsrValueTag, startIndex) + obsrValueTag.length();
		int obsrValueEndIndex = input.indexOf("</obsrValue>", obsrValueStartIndex);

		if (startIndex == -1 || obsrValueStartIndex == -1 || obsrValueEndIndex == -1) {
			return "";
		}

		return input.substring(obsrValueStartIndex, obsrValueEndIndex);
	}

	public static void processWeatherInfo(Model model, String location, String weatherInfo) {
		String vvvValue = extractValue(weatherInfo, "WSD");
		String t1hValue = extractValue(weatherInfo, "T1H");
		String rn1Value = extractValue(weatherInfo, "RN1");
		model.addAttribute(location + "_WindSpeed", vvvValue);
		model.addAttribute(location + "_Temperature", t1hValue);
		model.addAttribute(location + "_Rainfall1h", rn1Value);

	}

}
