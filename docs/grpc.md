The GRPC interface itself is documented in the proto-file `modules/api/proto`

You can test ist by generating a python client with the following commands:
```
python3 -m grpc_tools.protoc -I./proto --python_out=. --pyi_out=. --grpc_python_out=. ./proto/model.proto
python3 -m grpc_tools.protoc -I./proto --python_out=. --pyi_out=. --grpc_python_out=. ./proto/connections.proto
python3 -m grpc_tools.protoc -I./proto --python_out=. --pyi_out=. --grpc_python_out=. ./proto/persons.proto
```  
