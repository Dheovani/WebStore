package springboot.springapi.opentelemetry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.RateLimitingSampler;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SenderConfiguration;

@Configuration
public class JaegerConfig {

    @Bean
    public JaegerTracer jaegerTracer() {
        SamplerConfiguration sampler = new SamplerConfiguration()
            .withType(RateLimitingSampler.TYPE)
            .withParam(10);

        ReporterConfiguration reporter = new ReporterConfiguration()
            .withLogSpans(true)
            .withSender(new SenderConfiguration().withAgentHost("127.0.0.1"));

        return new io.jaegertracing
            .Configuration("springboot-springapi")
            .withSampler(sampler)
            .withReporter(reporter)
            .getTracer();
    }
    
}
