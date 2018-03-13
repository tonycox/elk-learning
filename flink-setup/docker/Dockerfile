FROM openjdk:8-jre-alpine
MAINTAINER Anton Solovev "tonycoxbk@gmail.com"

# Install dependencies, bash and su-exec for easy step-down from root
RUN apk add --no-cache bash libc6-compat snappy 'su-exec>=0.2'

# Configure Flink version
ENV FLINK_VERSION=1.4.1 \
    SCALA_VERSION=2.11

# Prepare environment
ENV FLINK_HOME=/opt/flink
ENV PATH=$FLINK_HOME/bin:$PATH
RUN addgroup -S -g 9999 flink && \
    adduser -D -S -H -u 9999 -G flink -h $FLINK_HOME flink
WORKDIR $FLINK_HOME

ENV FLINK_URL_FILE_PATH=flink/flink-${FLINK_VERSION}/flink-${FLINK_VERSION}-bin-scala_${SCALA_VERSION}.tgz
# Not all mirrors have the .asc files
ENV FLINK_TGZ_URL=https://www.apache.org/dyn/closer.cgi?action=download&filename=${FLINK_URL_FILE_PATH} \
    FLINK_ASC_URL=https://www.apache.org/dist/${FLINK_URL_FILE_PATH}.asc

# Install Flink
RUN set -ex; \
  apk add --no-cache --virtual .build-deps \
    ca-certificates \
    gnupg \
    openssl \
    tar \
  ; \
  \
  wget -nv -O flink.tgz "$FLINK_TGZ_URL"; \
  wget -nv -O flink.tgz.asc "$FLINK_ASC_URL"; \
  tar -xf flink.tgz --strip-components=1; \
  rm flink.tgz; \
  \
  apk del .build-deps; \
  \
  chown -R flink:flink .;

# Configure container
COPY docker-entrypoint.sh docker-entrypoint.sh
ENTRYPOINT ["sh", "docker-entrypoint.sh"]
EXPOSE 6123 8081
