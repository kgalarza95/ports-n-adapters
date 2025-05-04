package com.kgalarza.hexagonal_architecture.domain.port.out;

public interface ILogBusMessagePort {
    public void sendMessage(String message);
}
