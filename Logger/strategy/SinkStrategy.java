/**
 * Alipay.com Inc. Copyright (c) 2004-2021 All Rights Reserved.
 */
package designLogger.strategy;

import designLogger.model.Message;

/**
 * Logger Library
 * @version $Id: SinkStrategy.java, v 0.1 2021-03-07 10:50 PM 
 */
@FunctionalInterface
public interface SinkStrategy {

    void write(Message message);

}