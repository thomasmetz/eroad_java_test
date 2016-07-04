package com.eroad.io;

/**
 * 
 * @author thomasmetz
 *
 * @param <RQ>
 * @param <RS>
 */
public interface EroadFileReader<RQ, RS> {

	RS readFile(RQ rq);
	boolean appendFile(RS rs, String path);
	
}
