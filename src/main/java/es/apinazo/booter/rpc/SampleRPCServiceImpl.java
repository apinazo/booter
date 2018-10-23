package es.apinazo.booter.rpc;

import org.springframework.stereotype.Service;

/**
 * Sample RPC service implementation.
 *
 * jsonrpc4j needs both an interface and an implementation of the service.
 */
@Service
public class SampleRPCServiceImpl implements SampleRPCService {

    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
