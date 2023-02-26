FROM python:3.7-alpine

WORKDIR .

RUN apk add --no-cache gcc musl-dev linux-headers geos libc-dev postgresql-dev
COPY requirements.txt requirements.txt
COPY proto ./proto

RUN pip install -r requirements.txt
RUN python3 -m grpc_tools.protoc -I./proto --python_out=. --pyi_out=. --grpc_python_out=. ./proto/model.proto \
    && python3 -m grpc_tools.protoc -I./proto --python_out=. --pyi_out=. --grpc_python_out=. ./proto/connections.proto \
    && python3 -m grpc_tools.protoc -I./proto --python_out=. --pyi_out=. --grpc_python_out=. ./proto/persons.proto

EXPOSE 5000

COPY . .
CMD ["flask", "run", "--host", "0.0.0.0"]