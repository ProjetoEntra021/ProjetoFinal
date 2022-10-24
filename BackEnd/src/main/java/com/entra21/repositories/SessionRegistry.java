package com.entra21.repositories;

public class SessionRegistry {

//	public static final HashMap<String, String> SESSIONS = new HashMap<>();
//	private ValueOperations<String, String> redisSessionStorage;
//	
//	@Autowired
//	public SessionRegistry(final RedisTemplate<String, String> redisTemplate){
//		redisSessionStorage = redisTemplate.opsForValue();
//	}
//	
//	
//	public String registerSession(final String username) {
//		if(username == null) {
//			throw new RuntimeException("Username needs to be provided.");
//		}
//		
//		String sessionId = generateSessionId() + "14";
//		
//		try {
//			redisSessionStorage.set(sessionId, username);
//		} catch (Exception e) {
//			e.printStackTrace();
//			SESSIONS.put(username, sessionId);	
//		}
//		
//		return sessionId;
//	}
//	
//	public String getUsernameForSession(final String sessionId) {
//		try {
//			return redisSessionStorage.get(sessionId);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return SESSIONS.get(sessionId);	
//		}
//	}
//	
//	private String generateSessionId() {
//		return new String(Base64.getEncoder().encode(
//				UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)
//				)
//			);
//	}
}
