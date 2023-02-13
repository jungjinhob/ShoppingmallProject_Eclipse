package kyungsu.project.projects.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "member")
@Entity(name = "member")
public class MemberEntity {
	
	@Id
	private String id;
	private String password;
	@Column(unique = true)
	private String number;
	private String name;
	private String nickname;
	private String address;
	private int admin;

}
