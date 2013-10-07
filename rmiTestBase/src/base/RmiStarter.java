package base;

public abstract class RmiStarter {

	public RmiStarter(Class classToAddToServerCodebase){
		String codebase = classToAddToServerCodebase.getProtectionDomain().getCodeSource().getLocation().toString();
		String policyFileLocation = PolicyFileLocator.getLocationOfPolicyFile();
		System.setProperty("java.rmi.server.codebase",	codebase );
		System.setProperty("java.security.policy", policyFileLocation);
		System.out.println("codebase: " + codebase);
		System.out.println("policy file: " + policyFileLocation);
		if (System.getSecurityManager() == null){
			System.setSecurityManager(new SecurityManager());
		}
		
		doCustomRmiHandling();
	}
	
	public abstract void doCustomRmiHandling();
}
