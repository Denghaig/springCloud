package dd.dhg.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
//自定义链接规则
@Configuration
public class MyRule {
	@Bean
	public IRule myRule() {
		//return new RandomRule_ZY();//自定义的链接算法
		return new RoundRobinRule();//ribbon自带的 默认的轮转算法
	}
}
