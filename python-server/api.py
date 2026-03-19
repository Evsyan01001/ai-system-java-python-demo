from fastapi import FastAPI, File, UploadFile

app = FastAPI()

@app.post("/Predict")
async def predict(file : UploadFile = File(...)):
    # Read the file content
    content = await file.read()
    
    # # Process the content (example logic - replace with actual prediction logic)
    # if content == b"fake":
    #     return {"result": "FAKE"}
    # else:
    #     return {"result": "REAL"}
    return {"filename": file.filename, "size": len(content)}
