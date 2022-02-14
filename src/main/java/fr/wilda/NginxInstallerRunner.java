package fr.wilda;

import java.io.IOException;

import fr.wilda.controller.NginxInstallerReconciler;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;

public class NginxInstallerRunner {
  public static void main(String[] args) throws IOException {
    Config config = new ConfigBuilder().withNamespace(null).build();
    KubernetesClient client = new DefaultKubernetesClient(config);

    Operator operator = new Operator(client, DefaultConfigurationService.instance());
    operator.register(new NginxInstallerReconciler(client));

    System.out.println("🚀 Starting NginxInstaller operator !!! 🚀");

    operator.start();
  }
}
