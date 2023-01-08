FROM node:16-alpine AS base
WORKDIR /app

ARG BUILD_VERSION=0.1.0
ARG GIT_COMMIT=unknown

LABEL org.opencontainers.image.version="${BUILD_VERSION}"\
      org.opencontainers.image.revision="${GIT_COMMIT}"

FROM base AS build

COPY . ./
RUN npm ci

RUN npm run check
RUN npm run test:unit
#RUN npm run test
RUN npm run build

FROM base AS release

COPY package.json .
COPY package-lock.json .
RUN npm ci --omit=dev

COPY --from=build /app/build/ .
EXPOSE 3000
CMD ["node", "index.js"]