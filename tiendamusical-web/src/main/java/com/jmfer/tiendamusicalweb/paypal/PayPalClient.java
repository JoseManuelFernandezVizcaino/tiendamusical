package com.jmfer.tiendamusicalweb.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
/**
 * 
 * @author jmfer
 * Clase Client de PayPal que configura las clases necesarias para realizar las transacciones 
 * hacia PayPal y tambien el CLIENT ID y SECRET ID de acceso a la aplicacion de Sandbox.
 */
public class PayPalClient {

  /**
   *Set up the PayPal Java SDK environment with PayPal access credentials.  
   *This sample uses SandboxEnvironment. In production, use LiveEnvironment.
   */
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
    "ASSFSS8vkKGKR-LPNKy1wvVfrO-M-Jnb8CKEEU9SIuUgmcn986y6KZI5nPUQbbidqiyMNosSEteCMQlH",
    "ELdNLiKhCVHt92OJ-njkJx5fcEZNsukGLSB0DI3PF3yeWe8Z4GojXg10-5g3HBiut8Ak9HIsS2YkroWl");

  /**
   *PayPal HTTP client instance with environment that has access
   *credentials context. Use to invoke PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   *Method to get client object
   *
   *@return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}