package dd.dhg.rule;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public  class RandomRule_ZY extends AbstractLoadBalancerRule {
	//total=0.// 当total等于5时就跳转到下一个服务器
	private int total=0;
	private int currentIndex=0;
	    public Server choose(ILoadBalancer lb, Object key) {
	        if (lb == null) {
	            return null;
	        }
	        Server server = null;

	      while (server == null) {
	            if (Thread.interrupted()) {
	                return null;
	            }
	            List<Server> upList = lb.getReachableServers();
	           // List<Server> allList = lb.getAllServers();

	           // int serverCount = allList.size();
	            /*   if (serverCount == 0) {
	                
	                 * No servers. End regardless of pass, because subsequent passes
	                 * only get more restrictive.
	                 
	                return null;
	            }

	            int index = chooseRandomInt(serverCount);
	            server = upList.get(index);
*/
	        if (total<5) {
				server=upList.get(currentIndex);
				total++;
			}else {
				total=0;
				currentIndex++;
				if (currentIndex>=upList.size()) {
					currentIndex=0;
				}
			}
	            if (server == null) {
	                /*
	                 * The only time this should happen is if the server list were
	                 * somehow trimmed. This is a transient condition. Retry after
	                 * yielding.
	                 */
	                Thread.yield();
	                continue;
	            }

	            if (server.isAlive()) {
	                return (server);
	            }

	            // Shouldn't actually happen.. but must be transient or a bug.
	            server = null;
	            Thread.yield();
	        }

	        return server;

	    }

	    protected int chooseRandomInt(int serverCount) {
	        return ThreadLocalRandom.current().nextInt(serverCount);
	    }

		@Override
		public Server choose(Object key) {
			// TODO Auto-generated method stub
			return choose(getLoadBalancer(), key);
		}

		@Override
		public void initWithNiwsConfig(IClientConfig arg0) {
			// TODO Auto-generated method stub
			
		}
	}


